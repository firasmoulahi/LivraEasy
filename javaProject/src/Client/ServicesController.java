/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javaproject.JavaProject;
import Login.*;


import DBUtil.*;


/**
 * FXML Controller class
 *
 * @author firas
 */
public class ServicesController implements Initializable {

    @FXML
    private AnchorPane services;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleFood(ActionEvent event) {
        services.getScene().getWindow().hide();
        try {
            
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Client/FXMLDocument.fxml"));

            
            Scene scene = new Scene(root);
            
            st.setTitle("Interface Login");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(JavaProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleOther(ActionEvent event) {
        
        services.getScene().getWindow().hide();
        try {
            
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Client/Others.fxml"));

            
            Scene scene = new Scene(root);
            
            st.setTitle("Interface Login");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(JavaProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleContact(ActionEvent event) {
        services.getScene().getWindow().hide();
        try {
            
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Client/contac.fxml"));

            
            Scene scene = new Scene(root);
            
            st.setTitle("Interface Login");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(JavaProject.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handleLogout(ActionEvent event) {
        services.getScene().getWindow().hide();
        try {
            
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Login/Login2.fxml"));

            
            Scene scene = new Scene(root);
            
            st.setTitle("Interface Login");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(JavaProject.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
