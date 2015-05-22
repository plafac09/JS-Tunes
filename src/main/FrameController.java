/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bl.PlaylistTrackModel;
import bl.TrackController;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jule
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
                    tcf.setAudioFilePath(filename);
                    tcf.start();
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
        System.out.println("Opening Track...");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        model = new PlaylistTrackModel(list);
    }

}
