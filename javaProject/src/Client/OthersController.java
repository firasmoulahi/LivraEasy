/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Client;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import Login.*;


import DBUtil.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javaproject.JavaProject;


/**
 * FXML Controller class
 *
 * @author firas
 */
public class OthersController implements Initializable {

    @FXML
    private TextField item;
    @FXML
    private TextField width;
    @FXML
    private TextField lenghth;
    @FXML
    private TextField height;
    @FXML
    private TextField from;
    @FXML
    private TextField to;
    @FXML
    private TextField distance;
    @FXML
    private ScrollPane scr;
    @FXML
    private AnchorPane checkV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    Connection con = null;
    PreparedStatement pstmt = null;
    @FXML
    private void items(ActionEvent event) {
        try {
            con = DataBase.getConnection();
            String sql = "INSERT INTO items (item, width, lenghth, height, de,a,distance) VALUES (?, ?, ?, ?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, item.getText());
            pstmt.setString(2, width.getText());
            pstmt.setString(3, lenghth.getText());
            pstmt.setString(4, height.getText());
            pstmt.setString(5, from.getText());
            pstmt.setString(6, to.getText());
            pstmt.setString(7, distance.getText());
            
            
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

    @FXML
    private void reserve(ActionEvent event) {
        
       double scrollToY = checkV.getBoundsInParent().getMinY();
        double scrollPaneHeight = scr.getHeight();

        // Calculer la valeur de défilement verticale pour afficher l'AnchorPane
        double vValue = scrollToY / (scr.getContent().getBoundsInLocal().getHeight() - scrollPaneHeight);

        // Réglez la valeur de défilement vertical du ScrollPane
        scr.setVvalue(vValue); 
           
                 
        
        
       
    }   

    @FXML
    private void contact(ActionEvent event) {
        
        scr.getScene().getWindow().hide();
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
    
            
        
        
    
        
    
    
}
