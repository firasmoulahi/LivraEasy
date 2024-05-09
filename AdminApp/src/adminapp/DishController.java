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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class DishController {

    
    @FXML private TextField txtName;
    @FXML private TextField txtPrice;
    @FXML private TextField txtRestaurant;
    

    @FXML private javafx.scene.control.TextArea resultConsole;
   
    
    
    
    @FXML private TableView dishTable;
    @FXML
    private TextField txtDesc;
    @FXML
    private TextField txtImg;
    @FXML
    private TextField searchold;
    @FXML
    private TextField searchNew;
    @FXML
    private AnchorPane dish;
    

    @FXML
    public void insertDish(javafx.event.ActionEvent event)  throws ClassNotFoundException, SQLException {
        dishTable.getItems().clear();
        try {
            AdmDishDAO.insertDish(txtName.getText(), txtDesc.getText(), Float.parseFloat(txtPrice.getText()), txtImg.getText(), txtRestaurant.getText() );
            resultConsole.setText("Success! Values has been added to DB");
            
        }catch (SQLException e){
            System.out.println("Exception occurs in Insertion " +e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void updateDish(ActionEvent event) throws ClassNotFoundException, SQLException{
        dishTable.getItems().clear();
        try {
            AdmDishDAO.updateDish(searchold.getText(), searchNew.getText());
            resultConsole.setText("Data was updated");
            

        }catch (SQLException e){
            System.out.println("Error while updating");
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void deleteDish(ActionEvent event) throws ClassNotFoundException,SQLException{
        dishTable.getItems().clear();
        try {
            AdmDishDAO.deleteDishById(searchold.getText());
            resultConsole.setText("Deleted successfully");
            
        }catch (SQLException e){
            System.out.println("Error occured while deleting the record");
            e.printStackTrace();
            throw e;
        }
    }

    public void initialize(URL url, ResourceBundle rb) {
        

    }

    private void addColumns() {
        TableColumn<Dish, String> colDishName = new TableColumn<>("Name");
        colDishName.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colDishName.setPrefWidth(100);
        TableColumn<Dish, String> colDishDesc = new TableColumn<>("Description");
        colDishDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colDishDesc.setPrefWidth(150);
        TableColumn<Dish, String> colDishImg = new TableColumn<>("Image");
        colDishImg.setCellValueFactory(new PropertyValueFactory<>("Image"));
        colDishImg.setPrefWidth(100);
        TableColumn<Dish, Float> colDishPrice = new TableColumn<>("Price");
        colDishPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colDishPrice.setPrefWidth(70);
        TableColumn<Dish, String> colDishNom_Res= new TableColumn<>("Nom_Res");
        colDishNom_Res.setCellValueFactory(new PropertyValueFactory<>("Nom_res"));
        colDishNom_Res.setPrefWidth(100);

        
        String style = "-fx-font-size: 14px;";
        colDishName.setStyle(style);
        colDishPrice.setStyle(style);
        colDishImg.setStyle(style);
        colDishNom_Res.setStyle(style);

        // Ajouter les colonnes à la TableView
        dishTable.getColumns().addAll(colDishName, colDishDesc, colDishImg,colDishPrice, colDishNom_Res);
    }

    @FXML
    private void searchDish(ActionEvent event) throws ClassNotFoundException, SQLException{
        if (dishTable.getColumns().isEmpty()) {
            
            addColumns();
        }
        ObservableList<Dish> restList = AdmDishDAO.searchDish(searchold.getText()) ;
        if (restList.size()>0){
            dishTable.getItems().clear();
            dishTable.setItems(restList);
            resultConsole.setText("Results found");
            for(int i=0;i<restList.size();i++)
                System.out.println(restList.get(i).toString());
        }
        else
            resultConsole.setText("no such record");


    }
    


    @FXML
    private void searchAllDishes(ActionEvent event) throws ClassNotFoundException,SQLException{
        if (dishTable.getColumns().isEmpty()) {
            
            addColumns();
        }
        ObservableList<Dish> restList = AdmDishDAO.getAllRecords() ;
        if (restList.size()>0){
            dishTable.getItems().clear();
            dishTable.setItems(restList);
            resultConsole.setText("Results found");
            for(int i=0;i<restList.size();i++)
                System.out.println(restList.get(i).toString());
        }
        else
            resultConsole.setText("no such record");
    }

    @FXML
    private void back(ActionEvent event) throws Exception {
        
        dish.getScene().getWindow().hide();
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
