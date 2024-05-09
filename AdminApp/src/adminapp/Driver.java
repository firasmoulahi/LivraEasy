package adminapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Driver {
    private StringProperty name;
    private StringProperty fname;
    private StringProperty username;
    private StringProperty password;
    

    public Driver(){
        this.name = new SimpleStringProperty();
        this.fname = new SimpleStringProperty();
        this.username = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
    }

    //for name
    public String getName(){
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty getCustomerName(){
        return name;
    }

    //for surname
    public String getUsername(){
        return username.get();
    }

    public void setUsername(String surname) {
        this.username.set(surname);
    }

    public StringProperty getCustomerUsernamename(){
        return username;
    }
     public String getFname(){
        return fname.get();
    }

    public void setFname(String name) {
        this.fname.set(name);
    }

    public StringProperty getCustomerFname(){
        return fname;
    }
    
     public String getPassword(){
        return password.get();
    }

    public void setPassword(String name) {
        this.password.set(name);
    }

    public StringProperty getCustomerPassword(){
        return password;
    }
    
    
    public static ObservableList<Driver> getAllRecords() throws ClassNotFoundException, SQLException {

        String sql = "select * from driver";

        try {
           Connection connection = DBUtil.DataBase.getConnection();
           
           
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           ResultSet resultSet = preparedStatement.executeQuery();
           System.out.println("Before while loop");
           
           ObservableList<Driver> drlist = FXCollections.observableArrayList();
           
           while (resultSet.next()) {
               System.out.println("entering while loop");
               Driver dr = new Driver();
               dr.setName(resultSet.getString("name"));
               dr.setFname(resultSet.getString("familyname"));
               dr.setUsername(resultSet.getString("username"));
               dr.setPassword(resultSet.getString("pwd"));
               
               
               drlist.add(dr);
               

              
               
           }
           System.out.println("after while loop");
           return drlist;
           // Fermez les ressources de la base de données
           
       } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(Dish.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }

    

    public static ObservableList<Driver> searchCust(String custName) throws ClassNotFoundException, SQLException{
        
        try {
           Connection connection = DBUtil.DataBase.getConnection();
           String sql = "select username, pwd, name, familyname from client where username = '"+custName+"'";
           
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           ResultSet resultSet = preparedStatement.executeQuery();
           System.out.println("Before while loop");
           
           ObservableList<Driver> drlist = FXCollections.observableArrayList();
           
           while (resultSet.next()) {
               System.out.println("entering while loop");
               Driver dr = new Driver();
               dr.setName(resultSet.getString("name"));
               dr.setFname(resultSet.getString("familyname"));
               dr.setUsername(resultSet.getString("username"));
               dr.setPassword(resultSet.getString("pwd"));
               
               
               drlist.add(dr);
               

              
               
           }
           System.out.println("after while loop");
           return drlist;
           // Fermez les ressources de la base de données
           
       } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(Dish.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }
    
    
    
}
