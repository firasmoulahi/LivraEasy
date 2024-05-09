package adminapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdministratorController {

    @FXML
    private AnchorPane home;
    
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    @FXML
    public void admDish(ActionEvent event)throws Exception{
        home.getScene().getWindow().hide();
        try {
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/adminapp/AdministratorDish.fxml"));

            
            Scene scene = new Scene(root);
            
            st.setTitle("Interface Login");
            st.setScene(scene);
            st.show();

        }catch (Exception e){
            System.out.println("Error occured while opening Dish page");
            e.printStackTrace();
            throw e;
        }

    }

    @FXML
    public void admRestaurant(ActionEvent event) throws Exception{
        home.getScene().getWindow().hide();
        try {

            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/adminapp/AdministratorRestaurant.fxml"));

            
            Scene scene = new Scene(root);
            
            st.setTitle("Interface Login");
            st.setScene(scene);
            st.show();

        }catch (Exception e){
            System.out.println("Error occured while opening Restaurants page");
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    public void admCustomer(ActionEvent event) throws Exception{
        home.getScene().getWindow().hide();
        try {

            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/adminapp/AdministratorCustomer.fxml"));

            
            Scene scene = new Scene(root);
            
            st.setTitle("Interface Login");
            st.setScene(scene);
            st.show();

        }catch (Exception e){
            System.out.println("Error occured while opening Restaurants page");
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void admDriver(ActionEvent event) throws Exception {
        home.getScene().getWindow().hide();
        try {

            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/adminapp/AdministratorDriver.fxml"));

            
            Scene scene = new Scene(root);
            
            st.setTitle("Interface Login");
            st.setScene(scene);
            st.show();

        }catch (Exception e){
            System.out.println("Error occured while opening Restaurants page");
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void admContact(ActionEvent event) throws Exception {
        
        home.getScene().getWindow().hide();
        try {

            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/adminapp/AdminContact.fxml"));

            
            Scene scene = new Scene(root);
            
            st.setTitle("Interface Login");
            st.setScene(scene);
            st.show();

        }catch (Exception e){
            System.out.println("Error occured while opening Restaurants page");
            e.printStackTrace();
            throw e;
        }
        
    }

   
}
