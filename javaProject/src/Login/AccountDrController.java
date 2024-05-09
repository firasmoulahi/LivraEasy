/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import Client.*;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javaproject.JavaProject;


/**
 * FXML Controller class
 *
 * @author firas
 */
public class AccountDrController implements Initializable {

    @FXML
    private TextField userDr;
    @FXML
    private TextField pwdDr;
    @FXML
    private TextField fnameDr;
    @FXML
    private TextField nameDr;
    @FXML
    private AnchorPane accDr;

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
    private void signupDr(ActionEvent event) {
        try {
            con = DataBase.getConnection();
            String sql = "INSERT INTO driver (username, pwd, Name, familyname) VALUES (?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userDr.getText());
            pstmt.setString(2, pwdDr.getText());
            pstmt.setString(3, nameDr.getText());
            pstmt.setString(4, fnameDr.getText());
            
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("added succ");
                accDr.getScene().getWindow().hide();
                try {

                    Stage st = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/Login/LoginDr.fxml"));


                    Scene scene = new Scene(root);

                    st.setTitle("Interface Login");
                    st.setScene(scene);
                    st.show();
                } catch (IOException ex) {
                    Logger.getLogger(JavaProject.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("not added succ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
}
