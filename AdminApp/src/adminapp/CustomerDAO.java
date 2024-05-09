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

public class CustomerDAO {

    public static ObservableList<Customer> getAllRecords() throws ClassNotFoundException, SQLException {

        String sql = "select * from client";

        try {
           Connection connection = DBUtil.DataBase.getConnection();
           String query = "select username, pwd, name, familyname from client";
           
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           ResultSet resultSet = preparedStatement.executeQuery();
           System.out.println("Before while loop");
           
           ObservableList<Customer> restlist = FXCollections.observableArrayList();
           
           while (resultSet.next()) {
               System.out.println("entering while loop");
               Customer cust = new Customer();
               cust.setName(resultSet.getString("name"));
               cust.setFname(resultSet.getString("familyname"));
               cust.setUsername(resultSet.getString("username"));
               cust.setPassword(resultSet.getString("pwd"));
               
               
               restlist.add(cust);
               

              
               
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

    

    public static ObservableList<Customer> searchCust(String custName) throws ClassNotFoundException, SQLException{
        
        try {
           Connection connection = DBUtil.DataBase.getConnection();
           String sql = "select username, pwd, name, familyname from client where username = '"+custName+"'";
           
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           ResultSet resultSet = preparedStatement.executeQuery();
           System.out.println("Before while loop");
           
           ObservableList<Customer> restlist = FXCollections.observableArrayList();
           
           while (resultSet.next()) {
               System.out.println("entering while loop");
               Customer cust = new Customer();
               cust.setName(resultSet.getString("name"));
               cust.setFname(resultSet.getString("familyname"));
               cust.setUsername(resultSet.getString("username"));
               cust.setPassword(resultSet.getString("pwd"));
               
               
               restlist.add(cust);
               

              
               
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
