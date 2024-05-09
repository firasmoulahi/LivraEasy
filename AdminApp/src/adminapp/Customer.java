package adminapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {
    private StringProperty name;
    private StringProperty fname;
    private StringProperty username;
    private StringProperty password;
    

    public Customer(){
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
}
