package adminapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Restaurant {

    private StringProperty nom_res;
    private StringProperty adress;

    public Restaurant(){
        this.nom_res = new SimpleStringProperty();
        this.adress = new SimpleStringProperty();
    }

    //for name
    public String getName(){
        return nom_res.get();
    }

    public void setName(String name) {
        this.nom_res.set(name);
    }

    public StringProperty getRestaurantName(){
        return nom_res;
    }

    //for address
    public String getAddress(){
        return adress.get();
    }

    public void setAddress(String address) {
        this.adress.set(address);
    }

    public StringProperty getRestaurantAddress(){
        return adress;
    }
    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + nom_res.get() + '\'' +
                ", address='" + adress.get() + '\'' +
                '}';
    }
}
