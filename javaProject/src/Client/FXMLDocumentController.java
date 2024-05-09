/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Client;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javafx.scene.text.Font;
import java.io.IOException;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javaproject.JavaProject;
import javaproject.JavaProject;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;


import Login.*;


import DBUtil.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;


/**
 *
 * @author Lenovo
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField SF;
    @FXML
    private ScrollPane scrol;
    @FXML
    private HBox menu;
    
    private void ouvrirInterfacePanier(Panier panier) {
    
}
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    
    
   private VBox createPlatVBox(String nom, String description, double prix, String imageNom, String nom_res) {
    // Créez un VBox pour chaque plat avec les informations appropriées
    VBox platVBox = new VBox();
    platVBox.setPrefWidth(138); // Remplacez 200 par la largeur souhaitée
    platVBox.setPrefHeight(223);
    platVBox.setStyle("-fx-background-color: white;");
    
    
    

    // Créez des étiquettes pour afficher les informations
    
    Label nomLabel = new Label( nom);
    
    
    nomLabel.setFont(new Font(17));
    nomLabel.setAlignment(Pos.CENTER);
    
    Label resLabel = new Label("Restaurant: "+nom_res);
    
    
    Label descriptionLabel = new Label( description);
    Label prixLabel = new Label( prix + " TND");
    descriptionLabel.setFont(new Font(14));
    prixLabel.setFont(new Font(13));
    descriptionLabel.setAlignment(Pos.CENTER);
    prixLabel.setAlignment(Pos.CENTER);
    resLabel.setFont(new Font(14));
    

    try {
        ImageView imageView = new ImageView(new Image("/img/" + imageNom+".png"));
        // Ajoutez les étiquettes au VBox
        imageView.setFitWidth(132);
        imageView.setFitHeight(79);
        
        platVBox.getChildren().addAll(imageView,nomLabel, descriptionLabel, prixLabel,resLabel );
        platVBox.setAlignment(Pos.CENTER);
        platVBox.setMargin(nomLabel, new Insets(0, 0, 0, 8));
        platVBox.setMargin(descriptionLabel, new Insets(10, 0, 0, 30));
        platVBox.setMargin(prixLabel, new Insets(10, 0, 0, 40));
    } catch (Exception e) {
        // Handle the exception (e.g., print the stack trace)
        e.printStackTrace();
    }

    // Ajoutez des styles ou des gestionnaires d'événements si nécessaire

    return platVBox;
}

    
    private void loadPlatsFromDatabase() {
       try {
           Connection connection = DBUtil.DataBase.getConnection();
           String query = "SELECT nom, description,image, prix, nom_res  FROM commande";
           
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           ResultSet resultSet = preparedStatement.executeQuery();
           System.out.println("Before while loop");
           Panier panier = new Panier(1);

           while (resultSet.next()) {
               
               
               System.out.println("entering while loop");
               
               String nom = resultSet.getString("nom");
               System.out.println("nom: " + nom);
               String description = resultSet.getString("description");
               System.out.println(description);
               float prix = resultSet.getFloat("prix");
               String imageNom = resultSet.getString("image");
               String nom_res = resultSet.getString("nom_res");
               
               Button addToCartButton = new Button("add to cart");
        
                addToCartButton.setPrefHeight(44.0);
                addToCartButton.setPrefWidth(105.0);
                addToCartButton.setStyle("-fx-background-color: #F72D57;");
                addToCartButton.setTextFill(javafx.scene.paint.Color.WHITE);

                // Padding
                addToCartButton.setPadding(new Insets(12.0, 10.0, 12.0, 10.0));

                // Font
                addToCartButton.setFont(new javafx.scene.text.Font(14.0));
               
               addToCartButton.setOnAction((event) -> {
            // Ajoutez le plat au panier lorsque le bouton est cliqué
                Plat plat = new Plat(nom, description, prix);
                panier.ajouterPlat(plat);
                System.out.println("Plat ajouté au panier : " + plat.getNom());
                System.out.println(  panier );
                
            });

               // Créez un VBox pour chaque plat
               VBox platVBox = createPlatVBox(nom, description, prix, imageNom, nom_res);
               platVBox.getChildren().addAll(addToCartButton);
               

               // Ajoutez le VBox au HBox
               menu.getChildren().add(platVBox);
               menu.setMargin(platVBox, new Insets(0, 0, 0, 20));
           }
           
           Button viewCartButton = new Button("Voir le panier");
            viewCartButton.setPrefHeight(44.0);
            viewCartButton.setPrefWidth(150.0);
            viewCartButton.setStyle("-fx-background-color: #4CAF50;");
            viewCartButton.setTextFill(javafx.scene.paint.Color.WHITE);
            viewCartButton.setFont(new javafx.scene.text.Font(14.0));
            

            viewCartButton.setOnAction((event) -> {
                // Ouvrir la nouvelle interface avec le TableView
                Stage panierStage = new Stage();

                // Créer le TableView pour afficher les éléments du panier
                TableView<Plat> tableViewPanier = new TableView<>();
                TableColumn<Plat, String> nomColonne = new TableColumn<>("Nom");
                nomColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));

                TableColumn<Plat, String> descriptionColonne = new TableColumn<>("Description");
                descriptionColonne.setCellValueFactory(new PropertyValueFactory<>("description"));

                TableColumn<Plat, Float> prixColonne = new TableColumn<>("Prix");
                prixColonne.setCellValueFactory(new PropertyValueFactory<>("prix"));

                tableViewPanier.getColumns().addAll(nomColonne, descriptionColonne, prixColonne);

                // Ajouter les données du panier au TableView
                ObservableList<Plat> platsObservableList = FXCollections.observableArrayList(panier.getPlats());
                tableViewPanier.setItems(platsObservableList);

                // Créer la scène
                Scene scene = new Scene(tableViewPanier, 400, 300);

                // Configurer la scène et afficher la fenêtre
                panierStage.setTitle("Panier");
                panierStage.setScene(scene);
                panierStage.show();
                        });

// Ajouter le bouton à la fin du menu
            menu.getChildren().add(viewCartButton);
           System.out.println("after while loop");
           // Fermez les ressources de la base de données
           
       } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadPlatsFromDatabase();
        
    }


    
    
    
    
    
    
    
        

    @FXML
    private void handleHome(ActionEvent event) {
        scrol.getScene().getWindow().hide();
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
    }

    @FXML
    private void handleContact1(ActionEvent event) {
        scrol.getScene().getWindow().hide();
        try {
            
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Client/contac.fxml"));

            
            Scene scene = new Scene(root);
            
            st.setTitle("Interface Login");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(JavaProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

