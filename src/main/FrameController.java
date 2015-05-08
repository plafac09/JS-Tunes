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
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jule
 */
public class FrameController implements Initializable
{

    private PlaylistTrackModel model;

    @FXML
    private Slider slider;
    @FXML
    private Button btPlayStop;
    @FXML
    private ListView list;

    public FrameController()
    {
    }

    @FXML
    public void onCreatePlaylist(ActionEvent evt)
    {
        System.out.println("Creating playlist...");
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
                btPlayStop.setText("Stop");
                TrackController tc = new TrackController();
                String filename = System.getProperty("user.dir") + File.separator + "scr" + File.separator + "res" + File.separator + "music" + File.separator + "Pitbul.mp3";
                tc.playTrack(filename);
                System.out.println("Playing...");
                break;
            case "Stop":
                btPlayStop.setText("Play");
                System.out.println("Stopping...");
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
