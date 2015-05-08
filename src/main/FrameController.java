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
import javafx.scene.control.Button;
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
    @FXML
    private Button btPlayStop;
    private TrackController tcf = null;
    private boolean thread = true;
    private String filename = System.getProperty("user.dir") + File.separator + "res" + File.separator + "music" + File.separator + "Lunar.mp3";

    
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
            case ">":
                if(thread)
                {                   
                    if(tcf != null && tcf.isAlive())
                    {
                        break;
                    }
                    btPlayStop.setText("||");          
                    tcf = new TrackController();
                    tcf.setAudioFilePath(filename);
                    tcf.start();
                    thread = false;
                }
                break;
            case "||":
                btPlayStop.setText(">");
                
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
        // TODO
    }

}
