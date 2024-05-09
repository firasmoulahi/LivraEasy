/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javaproject;
import Login.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Login.*;
import Client.*;

import DBUtil.*;


/**
 *
 * @author bouss
 */
public class JavaProject extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Login/Login1.fxml"));

            
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Interface Login");
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(true);
            

        // (Optional) Maximize the stage to the screen's resolution
            
        } catch (IOException ex) {
            Logger.getLogger(JavaProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
