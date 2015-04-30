/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bl.TrackController;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jule
 */
public class FrameController implements Initializable
{
    @FXML
    private Slider slider;
    
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
    public void onPlay(ActionEvent evt)
    {
        System.out.println("Playing...");
        TrackController tc = new TrackController();
        String filename = System.getProperty("user.dir")+File.separator+"scr"+File.separator+"res"+File.separator+"music"+File.separator+"Pitbul.mp3";
        tc.playTrack(filename);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

}
