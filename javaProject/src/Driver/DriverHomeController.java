/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Driver;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class DriverHomeController implements Initializable {

    @FXML
    private TableView<item> req;

    /**
     * Initializes the controller class.
     * 
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb)  {
        
        try {
            search();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DriverHomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DriverHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    
    private void addColumns() {
        TableColumn<item, String> colCustName = new TableColumn<>("name");
        colCustName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCustName.setPrefWidth(79);
        TableColumn<item, Float> colWidth = new TableColumn<>("width");
        colWidth.setCellValueFactory(new PropertyValueFactory<>("width"));
        colWidth.setPrefWidth(79);
        TableColumn<item, Float> colLength = new TableColumn<>("length");
        colLength.setCellValueFactory(new PropertyValueFactory<>("length"));
        colLength.setPrefWidth(79.5);
        TableColumn<item, Float> colHeight = new TableColumn<>("height");
        colHeight.setCellValueFactory(new PropertyValueFactory<>("height"));
        colHeight.setPrefWidth(79);
        TableColumn<item, String> colFrom = new TableColumn<>("from");
        colCustName.setCellValueFactory(new PropertyValueFactory<>("from"));
        colFrom.setPrefWidth(79);
        TableColumn<item, String> colTo = new TableColumn<>("to");
        colTo.setCellValueFactory(new PropertyValueFactory<>("to"));
        colTo.setPrefWidth(79);
        TableColumn<item, Float> colDist = new TableColumn<>("distance");
        colDist.setCellValueFactory(new PropertyValueFactory<>("distance"));
        colDist.setPrefWidth(79);
        TableColumn<item, String> colDisp = new TableColumn<>("dispo");
        colDisp.setCellValueFactory(new PropertyValueFactory<>("disponibility"));
        colDisp.setPrefWidth(106);
        TableColumn<item, String> colDecision = new TableColumn<>("décision");
        colDecision.setPrefWidth(106);
        colDecision.setCellValueFactory( new PropertyValueFactory<>("decision"));
        colDecision.setCellFactory(new Callback<TableColumn<item, String>, TableCell<item, String>>() {
        @Override
        public TableCell<item, String> call(TableColumn<item, String> param) {
            return new TableCell<item, String>() {
                final Button btnAccept = new Button("Accepter");

                @Override
                protected void updateItem(String itemm, boolean empty) {
                    super.updateItem(itemm, empty);

                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        setGraphic(btnAccept);
                        btnAccept.setOnAction(event -> {
                            item selectedItem = getTableView().getItems().get(getIndex());
                            selectedItem.setDisponibility("non disponible");
                        });
                    }
                }
            };
        }
    });

    
        
        
        
        
        
        
        

        // Ajouter les colonnes à la TableView
        req.getColumns().addAll(colCustName, colWidth, colLength,colHeight, colFrom,colTo,colDist, colDisp, colDecision );
    }
    
    
    
    private void search() throws ClassNotFoundException, SQLException {
        if (req.getColumns().isEmpty()) {
            
            addColumns();
        }
        ObservableList<item> custList = item.getAllRecords() ;
        if (custList.size()>0){
            req.getItems().clear();
            req.setItems(custList);
            
        }
        

    }
    
    
    
    
    
}
