/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Login;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import DBUtil.DataBase;
import javaproject.JavaProject;

import Client.*;

import DBUtil.*;


/**
 * FXML Controller class
 *
 * @author firas
 */
public class AccountController implements Initializable {

    @FXML
    private TextField uname;
    @FXML
    private TextField pass;
    @FXML
    private TextField fname;
    @FXML
    private TextField name;
    @FXML
    private AnchorPane ancAc;
    
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
    private void Create(ActionEvent event) {
        
        try {
            con = DataBase.getConnection();
            String sql = "INSERT INTO Client (username, pwd, Name, FamilyName) VALUES (?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, uname.getText());
            pstmt.setString(2, pass.getText());
            pstmt.setString(3, name.getText());
            pstmt.setString(4, fname.getText());
            
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("added succ");
                ancAc.getScene().getWindow().hide();
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
            } else {
                System.out.println("not added succ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    
}
