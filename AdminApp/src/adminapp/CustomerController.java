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

public class CustomerController {

    @FXML private TextField searchName;
    @FXML private TextArea resultConsole;

    
    @FXML private TableView<Customer> custTable;
    @FXML
    private AnchorPane cust;
    public void initialize(URL url, ResourceBundle rb) {
        

    }
    
    
    private void addColumns() {
        TableColumn<Customer, String> colCustName = new TableColumn<>("Name");
        colCustName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCustName.setPrefWidth(79);
        TableColumn<Customer, String> colCustFname = new TableColumn<>("lastName");
        colCustFname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        colCustFname.setPrefWidth(79);
        TableColumn<Customer, String> colCustUsername = new TableColumn<>("Username");
        colCustUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colCustUsername.setPrefWidth(79.5);
        TableColumn<Customer, String> colCustPwd = new TableColumn<>("Password");
        colCustPwd.setCellValueFactory(new PropertyValueFactory<>("password"));
        colCustPwd.setPrefWidth(79);
        
        
        String style = "-fx-font-size: 14px;";
        colCustName.setStyle(style);
        colCustFname.setStyle(style);
        colCustUsername.setStyle(style);
        colCustPwd.setStyle(style);

        // Ajouter les colonnes à la TableView
        custTable.getColumns().addAll(colCustName, colCustFname, colCustUsername,colCustPwd);
    }
    
    
    @FXML
    private void searchCustomer(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (custTable.getColumns().isEmpty()) {
            
            addColumns();
        }
        ObservableList<Customer> custList = CustomerDAO.searchCust(searchName.getText()) ;
        if (custList.size()>0){
            custTable.getItems().clear();
            custTable.setItems(custList);
            resultConsole.setText("Results found");
            
        }
        else
            resultConsole.setText("no such record");

    }

    @FXML
    private void searchAllCustomers(ActionEvent event) throws ClassNotFoundException,SQLException{
        if (custTable.getColumns().isEmpty()) {
            
            addColumns();
        }
        ObservableList<Customer> custList = CustomerDAO.getAllRecords() ;
        if (custList.size()>0){
            custTable.getItems().clear();
            custTable.setItems(custList);
            resultConsole.setText("Results found");
            
        }
        else
            resultConsole.setText("no such record");
        
    }

    @FXML
    private void back(ActionEvent event) throws Exception {
        cust.getScene().getWindow().hide();
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
