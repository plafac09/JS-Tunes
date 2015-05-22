/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import main.Main;
import bl.PlaylistTrackModel;
import bl.TrackController;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

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

    @FXML
    private Slider slider;
    @FXML
    private Button btPlayStop;
    @FXML
    private TrackController tcf = null;
    @FXML
    private boolean thread = true;
    @FXML
    private String filename = System.getProperty("user.dir") + File.separator + "res" + File.separator + "music" + File.separator + "Lunar.mp3";
    @FXML
    private ListView list;
    @FXML
    private ComboBox boxPlaylists;
    private File currentTrack;

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
    public void onChangeVolume(MouseEvent evt)
    {

    }

    @FXML
    public void onPlayStop(ActionEvent evt)
    {
        switch (btPlayStop.getText())
        {
            case "Play":
                btPlayStop.setText("Pause");
                if (thread)
                {
                    if (tcf != null && tcf.isAlive())
                    {
                        break;
                    }
                    tcf = new TrackController();
                  //  System.out.println("tcf initialisiert");
                    if(currentTrack.getAbsolutePath() != null)
                    {
                        tcf.setAudioFilePath(currentTrack.getAbsolutePath());
                    }
                    else
                        JOptionPane.showMessageDialog(null, "no song available");
                    tcf.start();
            try 
            {
                tcf.displayTrackInformation();
            } catch (Exception ex) {
                System.out.println("Exception in FrameController : onPlayStop: "+ex.toString());
            } 
                 //   System.out.println("tcf started in gui");
                    thread = false;
                }
                break;
            case "Pause":
                btPlayStop.setText("Play");
                tcf.setInter(true);
                thread = true;
                break;

        }
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
            currentTrack = f;
        }       
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {        
        model = new PlaylistTrackModel(list);
        options.add("All Songs");
        boxPlaylists.setItems(options);
    }

}
