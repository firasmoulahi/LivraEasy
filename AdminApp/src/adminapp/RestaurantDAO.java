package adminapp;

import DBUtil.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class RestaurantDAO {

    public static void insertRestaurant( String name, String address) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO restaurant(nom_res, adress) VALUES ('" + name + "', '" + address + "')";

        try{
            DataBase.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Error occured while inserting data");
            e.printStackTrace();
            throw e;
        }
    }

    

    
    public static ObservableList<Restaurant> getAllRecords() {
       try {
           Connection connection = DBUtil.DataBase.getConnection();
           String query = "SELECT *  FROM restaurant";
           
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           ResultSet resultSet = preparedStatement.executeQuery();
           System.out.println("Before while loop");
           
           ObservableList<Restaurant> restlist = FXCollections.observableArrayList();
           
           while (resultSet.next()) {
               System.out.println("entering while loop");
               Restaurant res = new Restaurant();
               res.setName(resultSet.getString("nom_res"));
               
               
               res.setAddress(resultSet.getString("adress")) ;
               restlist.add(res);
               

               // Créez un VBox pour chaque plat
               

               // Ajoutez le VBox au HBox
               
           }
           System.out.println("after while loop");
           return restlist;
           // Fermez les ressources de la base de données
           
       } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(Restaurant.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }

    
    public static ObservableList<Restaurant> searchRest(String restName) throws ClassNotFoundException, SQLException{
        
        try {
           Connection connection = DBUtil.DataBase.getConnection();
           String sql = "select nom_res,adress from restaurant where nom_res = '"+restName+"'";
           
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           ResultSet resultSet = preparedStatement.executeQuery();
           System.out.println("Before while loop");
           
           ObservableList<Restaurant> restlist = FXCollections.observableArrayList();
           
           while (resultSet.next()) {
               System.out.println("entering while loop");
               Restaurant res = new Restaurant();
               res.setName(resultSet.getString("nom_res"));
               
               
               res.setAddress(resultSet.getString("adress")) ;
               restlist.add(res);
               

               
               
           }
           System.out.println("after while loop");
           return restlist;
           // Fermez les ressources de la base de données
           
       } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(Restaurant.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }
}
