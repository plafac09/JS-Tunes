/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Jule
 */

//Erklärung Libraries:
    /*
    tritonus_share.. -> damit kann man alle Informationen einer Sounddatei einholen
    mp3spi.. -> damit kann man mp3-Files abspielen
    
    Webseite für Tutorial über Tritonus_schare..: http://www.javazoom.net/mp3spi/documents.html
    */

public class Main extends Application
{

    public static Stage mainStage;
    
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        //Lädt die FXML Datei
        Parent root = FXMLLoader.load(getClass().getResource("Frame.fxml"));
        //Scene = ähnlich wie Frame
        mainStage = primaryStage;
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}
