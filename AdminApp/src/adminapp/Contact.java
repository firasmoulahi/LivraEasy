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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author firas
 */
public class Contact {
    
    private StringProperty name;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty msg;

    public Contact() {
        this.name =  new SimpleStringProperty();
        this.phone =  new SimpleStringProperty();
        this.email =  new SimpleStringProperty();
        this.msg =  new SimpleStringProperty();
    }
    
    

    public String getName() {
        return name.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getMsg() {
        return msg.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setPhone(String phone) {
        this.phone.set(phone); 
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setMsg(String msg) {
        this.msg.set(msg);
    }
    
    
    public static ObservableList<Contact> getAllRecords() throws ClassNotFoundException, SQLException {

        

        try {
           Connection connection = DBUtil.DataBase.getConnection();
           String query = "select * from msg";
           
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           ResultSet resultSet = preparedStatement.executeQuery();
           System.out.println("Before while loop");
           
           ObservableList<Contact> conlist = FXCollections.observableArrayList();
           
           while (resultSet.next()) {
               System.out.println("entering while loop");
               Contact con  = new Contact();
               con.setName(resultSet.getString("name"));
               con.setPhone(resultSet.getString("phone"));
               con.setEmail(resultSet.getString("email"));
               con.setMsg(resultSet.getString("msg"));
               
               
               conlist.add(con);
               

              
               
           }
           System.out.println("after while loop");
           return conlist;
           // Fermez les ressources de la base de données
           
       } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(Dish.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }
}
