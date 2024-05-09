package adminapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class AdminApp extends Application {

    @Override
    public void start(Stage primaryStage){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/adminapp/AdministratorView.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException ex) {
            Logger.getLogger(AdminApp.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
     public static void main(String[] args) {
        launch(args);
    }
}
