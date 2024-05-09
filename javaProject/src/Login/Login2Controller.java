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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
public class Login2Controller implements Initializable {

    @FXML
    private AnchorPane log2;
    @FXML
    private TextField user;
    @FXML
    private TextField pwd;
    
    PreparedStatement pstmt=null;
    Connection con=null;
    ResultSet rs=null;
    @FXML
    private Label lab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginC(ActionEvent event) {
        
        try {
                    con=DataBase.getConnection();
                    con.createStatement();
                    String sql = "select username, pwd from Client where username=? and pwd=?";
                    pstmt = con.prepareStatement(sql);
                    System.out.println("Executing SQL Query: " + sql);
                    System.out.println("Username: " + user.getText());
                    System.out.println("Password: " + pwd.getText());
                    pstmt.setString(1,user.getText().trim());
                    pstmt.setString(2, pwd.getText().trim());
                    rs = pstmt.executeQuery();
                    System.out.println(rs);
                    
                    
                    
                    if(rs.next()) {
                            System.out.println("Login Sucessfully!");
                            log2.getScene().getWindow().hide();
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
                            
                    }else{
                            System.out.println("Login Not Sucessfully!");
                            lab.setText("account not found");
                    }
            } catch (SQLException e) {
                    e.printStackTrace();
            }
	}

    
    

    @FXML
    private void accountAction(ActionEvent event) {
        log2.getScene().getWindow().hide();
        try {
            
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Login/Account.fxml"));

            
            Scene scene = new Scene(root);
            
            st.setTitle("Interface Login");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(JavaProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void back(MouseEvent event) {
        log2.getScene().getWindow().hide();
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
