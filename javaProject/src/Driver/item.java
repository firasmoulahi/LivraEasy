/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author firas
 */
public class item {
    private StringProperty name;
    private FloatProperty width;
    private FloatProperty length;
    private FloatProperty height;
    private StringProperty from;
    private StringProperty to;
    private FloatProperty distance;
    private StringProperty disponibility;
    
    public item(){
        this.name = new SimpleStringProperty();
        this.width = new SimpleFloatProperty();
        this.length = new SimpleFloatProperty();
        this.height = new SimpleFloatProperty();
        this.from = new SimpleStringProperty();
        this.to = new SimpleStringProperty();
        this.distance = new SimpleFloatProperty();
        this.disponibility = new SimpleStringProperty();
    }
    

    public String getName() {
        return name.get();
    }

    public Float getWidth() {
        return width.get();
    }

    public Float getLength() {
        return length.get();
    }

    public Float getHeight() {
        return height.get();
    }

    public String getFrom() {
        return from.get();
    }

    public String getTo() {
        return to.get();
    }

    public Float getDistance() {
        return distance.get();
    }

    

   

    public void setName(String name) {
        this.name.set(name);
    }

    public void setWidth(float width) {
        this.width.set(width); 
    }

    public void setLength(float length) {
        this.length.set(length);
    }

    public void setHeight(float height) {
        this.height.set(height);
    }

    public void setFrom(String from) {
        this.from.set(from);
    }

    public void setTo(String to) {
        this.to.set(to);
    }

    public void setDistance(float distance) {
        this.distance.set(distance);
    }

    public void setDisponibility(String disponibility) {
        this.disponibility.set(disponibility);
    }
    
    public StringProperty disponibilityProperty() {
        return disponibility;
    }
    
    public static ObservableList<item> getAllRecords() throws ClassNotFoundException, SQLException {

        String sql = "select * from items";

        try {
           Connection connection = DBUtil.DataBase.getConnection();
           
           
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           ResultSet resultSet = preparedStatement.executeQuery();
           System.out.println("Before while loop");
           
           ObservableList<item> restlist = FXCollections.observableArrayList();
           
           while (resultSet.next()) {
               System.out.println("entering while loop");
               item it = new item();
               it.setName(resultSet.getString("item"));
               it.setWidth(Float.parseFloat(resultSet.getString("width")));
               it.setHeight(Float.parseFloat(resultSet.getString("height")));
               it.setLength(Float.parseFloat(resultSet.getString("lenghth")));
               it.setFrom(resultSet.getString("de"));
               it.setTo(resultSet.getString("a"));
               it.setDistance(Float.parseFloat(resultSet.getString("distance")));
               it.setDisponibility("disponible");
               
               
               
               
               
               restlist.add(it);
               

              
               
           }
           System.out.println("after while loop");
           return restlist;
           // Fermez les ressources de la base de données
           
       } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(item.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }

        
    
    
    
}
