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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javaproject.JavaProject;
import Login.*;


import DBUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * FXML Controller class
 *
 * @author firas
 */
public class ContacController implements Initializable {

    @FXML
    private AnchorPane contact;
    @FXML
    private TextField msg;
    @FXML
    private TextField name;
    @FXML
    private TextField mail;
    @FXML
    private TextField phone;


    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleHome(ActionEvent event) {
        contact.getScene().getWindow().hide();
        try {
            
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Client/Services.fxml"));

            
            Scene scene = new Scene(root);
            
            st.setTitle("Interface Login");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(JavaProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void send(ActionEvent event) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DataBase.getConnection();
            String sql = "INSERT INTO Msg (name,phone ,email ,msg ) VALUES (?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name.getText());
            pstmt.setString(2, phone.getText());
            pstmt.setString(3, mail.getText());
            pstmt.setString(4, msg.getText());
            
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("added succ");
                
            } else {
                System.out.println("not added succ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
    }

    
}
