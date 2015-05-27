/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bl.PlaylistTrackModel;
import bl.Track;
import bl.TrackController;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jule
 *
 * Musik Länge anzeigen:
 * https://www.tutorials.de/threads/java-songlaenge-auslesen.337536/
 *
 */
public class FrameController implements Initializable
{

    private PlaylistTrackModel model;
    private ObservableList<String> options = FXCollections.observableArrayList();

    //Components
    @FXML
    private Slider slider;
    @FXML
    private Button btPlayStop;
    private TrackController tcf = null;
    private boolean thread = true;
    private String filename = System.getProperty("user.dir") + File.separator + "res" + File.separator + "music" + File.separator + "Lunar.mp3";
    @FXML
    private ListView list;
    @FXML
    private ComboBox boxPlaylists;
    @FXML
    private Label lbAlbum;
    @FXML
    private Label lbGenre;
    @FXML
    private Label lbReleaseYear;
    @FXML
    private Label lbArtist;
    @FXML
    private Label lbCurrentTrack;
    @FXML
    private Label lbCurrentTime;
    @FXML
    private Label lbTime;

    //Other
    private File currentTrack;
    private Track t = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    public FrameController()
    {

    }

    @FXML
    public void onCreatePlaylist(ActionEvent evt) 
    {
        System.out.println("Creating playlist...");
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Input");
        dialog.setHeaderText("Create a new Album");
        dialog.setContentText("Enter a name: ");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) 
        {
            options.add(result.get());
            boxPlaylists.setItems(options);
        }
    }

    @FXML
    public void onChangeVolume(MouseEvent evt) {

    }

    @FXML
    public void onPlayStop(ActionEvent evt) 
    {
        switch (btPlayStop.getText()) 
        {
            
            case "Play":
                try 
                {
                    btPlayStop.setText("Pause");
                    if (thread) 
                    {
                        if (tcf != null && tcf.isAlive()) {
                            break;
                        }
                        tcf = new TrackController();
                        //  System.out.println("tcf initialisiert");
                        if (currentTrack.getPath() != null) 
                        {
                            tcf.setAudioFilePath(currentTrack.getPath());
                            System.out.println("funkt");
                            t = new Track(currentTrack.getPath());
                            tcf.start();
                            tcf.saveTrackInfo(t);
                            displayTrackInfo(t);
                        } else //JOptionPane.showMessageDialog(null, "no song available");
                        {
                            System.out.println("no song available");
                        }                       
                    }
                    thread = false;
                } 
                catch (Exception ex) 
                {
                    System.out.println("Exception in FrameController : onPlayStop: " + ex.toString());
                }
                 //   System.out.println("tcf started in gui");
                break;
            case "Pause":
                btPlayStop.setText("Play");
                tcf.setInter(true);
                thread = true;
                break;
        }
    }
    
    public void displayTrackInfo(Track tr)
    {
        lbArtist.setText("Artist: "+tr.getArtist());
        lbAlbum.setText("Album: "+tr.getAlbum());
        lbCurrentTrack.setText(tr.getTitle());
        lbReleaseYear.setText("Release Year: "+sdf.format(tr.getPub_year()));
    }

    @FXML
    public void onOpenTrack(ActionEvent evt) 
    {
        //File Chooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("MP3 Files", "*.mp3"));
        File selectedFile = fileChooser.showOpenDialog(Main.mainStage);
        if (selectedFile != null)
        {
            File f = selectedFile;
            //  Track t = new Track()
            model.addTrack(f);
        }
        System.out.println("Opening Track...");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new PlaylistTrackModel(list);
        options.add("all Songs");
        boxPlaylists.setItems(options);
    }

}
