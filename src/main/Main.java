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
public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        //Lädt die FXML Datei
        Parent root = FXMLLoader.load(getClass().getResource("Frame.fxml"));
        //Scene = ähnlich wie Frame
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
