/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bl.PlaylistTrackModel;
import bl.Track;
import bl.TrackController;
import custom.PlayButton;
import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    //This is temporarily used to add Testdata
    @FXML
    public void onCreatePlaylist(ActionEvent evt)
    {
        System.out.println("Creating playlist...");
        try
        {
            model.addTrack(new Track("Aquamaria", "Colour Haze",
                    "Tempel", "2009", 0, "Psychedelic Rock", 523));
        } catch (ParseException ex)
        {
            System.out.println("Error in Frame Controller: onCreatePlayList: "
                    + ex.getMessage());
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
