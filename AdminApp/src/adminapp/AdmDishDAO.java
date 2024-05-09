package adminapp;
import DBUtil.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AdmDishDAO {

    public static void insertDish( String nom, String description, float prix, String imageNom, String nom_res)throws SQLException, ClassNotFoundException{
        String sql = "insert into commande(nom, description, image, prix, nom_res) values('"+nom+"', '"+description+"', '"+imageNom+"', '"+prix+"', '"+nom_res+"')";
        try {
            DataBase.dbExecuteQuery(sql);

        }catch (SQLException e){
            System.out.println("Exception occured while inserting data");
        }
    }

    public static void updateDish(String OldName, String name) throws ClassNotFoundException, SQLException{

        String sql = "update commande set nom = '"+name+"' where nom = '"+OldName+"'";

        try{
            DataBase.dbExecuteQuery(sql);

        }catch (SQLException e){
            System.out.println("Error occured while updating the record");
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteDishById(String name) throws SQLException, ClassNotFoundException{
        String sql = "delete from commande where nom = '"+name+"'";

        try {
            DataBase.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Error occured while deleting the Record");
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Dish> getAllRecords() throws ClassNotFoundException, SQLException{
        try {
           Connection connection = DBUtil.DataBase.getConnection();
           String query = "SELECT *  FROM commande";
           
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           ResultSet resultSet = preparedStatement.executeQuery();
           System.out.println("Before while loop");
           
           ObservableList<Dish> restlist = FXCollections.observableArrayList();
           
           while (resultSet.next()) {
               System.out.println("entering while loop");
               Dish dish = new Dish();
               dish.setNom(resultSet.getString("nom"));
               dish.setDescription(resultSet.getString("description"));
               dish.setImg(resultSet.getString("image"));
               dish.setPrice(Float.parseFloat(resultSet.getString("prix")));
               dish.setNom_res(resultSet.getString("nom_res"));
               
               restlist.add(dish);
               

              
               
           }
           System.out.println("after while loop");
           return restlist;
           // Fermez les ressources de la base de données
           
       } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(Dish.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }

    

    public static ObservableList<Dish> searchDish(String name ) throws ClassNotFoundException, SQLException{
        
        try {
           Connection connection = DBUtil.DataBase.getConnection();
           String sql = "select * from commande where nom = '"+name+"'";
           
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           ResultSet resultSet = preparedStatement.executeQuery();
           System.out.println("Before while loop");
           
           ObservableList<Dish> restlist = FXCollections.observableArrayList();
           
           while (resultSet.next()) {
               System.out.println("entering while loop");
               Dish dish = new Dish();
               dish.setNom(resultSet.getString("nom"));
               dish.setDescription(resultSet.getString("description"));
               dish.setImg(resultSet.getString("image"));
               dish.setPrice(Float.parseFloat(resultSet.getString("prix")));
               dish.setNom_res(resultSet.getString("nom_res"));
              

               
               
               
               
               restlist.add(dish);
               

              
               
           }
           System.out.println("after while loop");
           return restlist;
           // Fermez les ressources de la base de données
           
       } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(Dish.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }
}
