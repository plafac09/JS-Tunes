/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
