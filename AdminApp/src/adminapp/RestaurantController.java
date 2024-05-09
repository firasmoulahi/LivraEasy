package adminapp;

import java.net.URL;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;


import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.layout.AnchorPane;

public class RestaurantController {


    @FXML private TextField txtName;
    @FXML private TextField txtAddress;
    @FXML private TextArea resultConsole;
    @FXML private TextField searchName;

    @FXML private TableView<Restaurant> restTable;
    @FXML
    private AnchorPane rest;

    @FXML
    public void insertRestaurant(javafx.event.ActionEvent event)  throws ClassNotFoundException, SQLException {
        try {
            RestaurantDAO.insertRestaurant(txtName.getText(), txtAddress.getText());
            resultConsole.setText("Success! Values has been added to DB");
            ObservableList<Restaurant> restList = RestaurantDAO.getAllRecords();
            populateTable(restList);

        }catch (SQLException e){
            System.out.println("Exception occurs in Insertion " +e);
            e.printStackTrace();
            throw e;
        }
    }

    public void populateTable(ObservableList<Restaurant> restList){
        
        restTable.setItems(restList);
    }

    public void initialize(URL url, ResourceBundle rb) {
        
        
    }
    
    
    private void addColumns() {
        TableColumn<Restaurant, String> colRestName = new TableColumn<>("Name");
        colRestName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRestName.setPrefWidth(245);

        TableColumn<Restaurant, String> colRestAddress = new TableColumn<>("Address");
        colRestAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colRestAddress.setPrefWidth(245);
        String style = "-fx-font-size: 16px;";
        colRestName.setStyle(style);
        colRestAddress.setStyle(style);

        // Ajouter les colonnes à la TableView
        restTable.getColumns().addAll(colRestName, colRestAddress);
    }

    @FXML
    private void searchRestaurant(ActionEvent event) throws ClassNotFoundException, SQLException{
        
        if (restTable.getColumns().isEmpty()) {
            
            addColumns();
        }
        ObservableList<Restaurant> restList = RestaurantDAO.searchRest(searchName.getText()) ;
        if (restList.size()>0){
            restTable.getItems().clear();
            restTable.setItems(restList);
            resultConsole.setText("Results found");
            for(int i=0;i<restList.size();i++)
                System.out.println(restList.get(i).toString());
        }
        else
            resultConsole.setText("no such record");
    }

    
    
    
    @FXML
    private void searchAllRestaurants(ActionEvent event) throws ClassNotFoundException,SQLException{
        
        if (restTable.getColumns().isEmpty()) {
            addColumns();
        }
        ObservableList<Restaurant> restList = RestaurantDAO.getAllRecords();
        if (restList.size()>0){
            restTable.getItems().clear();
            restTable.setItems(restList);
            resultConsole.setText("Results found");
            for(int i=0;i<restList.size();i++)
                System.out.println(restList.get(i).toString());
        }
        else
            resultConsole.setText("no such record");
        
    }

    @FXML
    private void back(ActionEvent event) throws Exception {
        rest.getScene().getWindow().hide();
        try {
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/adminapp/AdministratorView.fxml"));

            
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
}

    


