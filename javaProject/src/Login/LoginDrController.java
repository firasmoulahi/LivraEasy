/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Login;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javaproject.JavaProject;

import Client.*;
import Driver.*;

import DBUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author firas
 */
public class LoginDrController implements Initializable {

    @FXML
    private AnchorPane logDr;
    
    
    
    @FXML
    private TextField drUser;
    @FXML
    private TextField drPwd;
    @FXML
    private Label lab1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    PreparedStatement pstmt=null;
    Connection con=null;
    ResultSet rs=null;
    @FXML
    private void loginD(ActionEvent event) {
        
        try {
                    con=DataBase.getConnection();
                    con.createStatement();
                    String sql = "select username, pwd from driver where username=? and pwd=?";
                    pstmt = con.prepareStatement(sql);
                    
                    
                    pstmt.setString(1,drUser.getText().trim());
                    pstmt.setString(2, drPwd.getText().trim());
                    rs = pstmt.executeQuery();
                    System.out.println(rs);
                    
                    
                    
                    if(rs.next()) {
                            System.out.println("Login Sucessfully!");
                            logDr.getScene().getWindow().hide();
                            try {

                                Stage st = new Stage();
                                Parent root = FXMLLoader.load(getClass().getResource("/Driver/DriverHome.fxml"));


                                Scene scene = new Scene(root);

                                st.setTitle("Interface Login");
                                st.setScene(scene);
                                st.show();
                            } catch (IOException ex) {
                                Logger.getLogger(JavaProject.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                    }else{
                            System.out.println("Login Not Sucessfully!");
                            lab1.setText("account not found");
                    }
            } catch (SQLException e) {
                    e.printStackTrace();
            }
    }

    @FXML
    private void accountActionDr(ActionEvent event) {
        logDr.getScene().getWindow().hide();
        try {
            
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Login/AccountDr.fxml"));

            
            Scene scene = new Scene(root);
            
            st.setTitle("Interface Login");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(JavaProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void backDr(MouseEvent event) {
        logDr.getScene().getWindow().hide();
        try {
            
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Login/Login1.fxml"));

            
            Scene scene = new Scene(root);
            
            st.setTitle("Interface Login");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(JavaProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
