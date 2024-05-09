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

import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class AdministratorDriverController {

    @FXML private TextField searchName;
    @FXML private TextArea resultConsole;

    
    
    
    @FXML
    private TableView<Driver> drTable;
    @FXML
    private AnchorPane driv;
    
    public void initialize(URL url, ResourceBundle rb) {
        

    }
    
    
    private void addColumns() {
        TableColumn<Driver, String> colDrName = new TableColumn<>("Name");
        colDrName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDrName.setPrefWidth(79);
        TableColumn<Driver, String> colDrFname = new TableColumn<>("lastName");
        colDrFname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        colDrFname.setPrefWidth(79);
        TableColumn<Driver, String> colDrUsername = new TableColumn<>("Username");
        colDrUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colDrUsername.setPrefWidth(79.5);
        TableColumn<Driver, String> colDrPwd = new TableColumn<>("Password");
        colDrPwd.setCellValueFactory(new PropertyValueFactory<>("password"));
        colDrPwd.setPrefWidth(79);
        
        
        String style = "-fx-font-size: 14px;";
        colDrName.setStyle(style);
        colDrFname.setStyle(style);
        colDrUsername.setStyle(style);
        colDrPwd.setStyle(style);

        // Ajouter les colonnes à la TableView
        drTable.getColumns().addAll(colDrName, colDrFname, colDrUsername,colDrPwd);
    }
    
    
    @FXML
    private void searchDriver(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (drTable.getColumns().isEmpty()) {
            
            addColumns();
        }
        ObservableList<Driver> drlist = Driver.searchCust(searchName.getText()) ;
        if (drlist.size()>0){
            drTable.getItems().clear();
            drTable.setItems(drlist);
            resultConsole.setText("Results found");
            
        }
        else
            resultConsole.setText("no such record");

    }

    @FXML
    private void searchAllDrivers(ActionEvent event) throws ClassNotFoundException,SQLException{
        if (drTable.getColumns().isEmpty()) {
            
            addColumns();
        }
        ObservableList<Driver> drList = Driver.getAllRecords();
        if (drList.size()>0){
            drTable.getItems().clear();
            drTable.setItems(drList);
            resultConsole.setText("Results found");
            
        }
        else
            resultConsole.setText("no such record");
        
    }

    @FXML
    private void back(ActionEvent event) throws Exception {
        driv.getScene().getWindow().hide();
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
