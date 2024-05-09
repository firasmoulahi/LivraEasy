/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package adminapp;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author firas
 */
public class AdminContactController implements Initializable {

    @FXML
    private AnchorPane rest;
    @FXML
    private TextArea resultConsole;
    @FXML
    private TableView<Contact> msgTable;

    /**
     * Initializes the controller class.
     */
    
    
    private void addColumns() {
        TableColumn<Contact, String> colConName = new TableColumn<>("Name");
        colConName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colConName.setPrefWidth(100);
        TableColumn<Contact, String> colConPhone = new TableColumn<>("phone");
        colConPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colConPhone.setPrefWidth(100);
        TableColumn<Contact, String> colConMail = new TableColumn<>("Email");
        colConMail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colConMail.setPrefWidth(100);
        TableColumn<Contact, String> colConMsg = new TableColumn<>("Message");
        colConMsg.setCellValueFactory(new PropertyValueFactory<>("msg"));
        colConMsg.setPrefWidth(346);
        
        
        String style = "-fx-font-size: 14px;";
        colConName.setStyle(style);
        colConPhone.setStyle(style);
        colConMail.setStyle(style);
        colConMsg.setStyle(style);

        // Ajouter les colonnes à la TableView
        msgTable.getColumns().addAll(colConName, colConPhone, colConMail,colConMsg);
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fullTable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminContactController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminContactController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }    

    @FXML
    private void back(ActionEvent event) {
        
        
    }
    
    public void fullTable() throws ClassNotFoundException, SQLException{
        
        
        if (msgTable.getColumns().isEmpty()) {
            
            addColumns();
        }
        ObservableList<Contact> conList = Contact.getAllRecords();
        if (conList.size()>0){
            msgTable.getItems().clear();
            msgTable.setItems(conList);
            resultConsole.setText("Results found");
            
        }
        
    }
    
     
    
}
