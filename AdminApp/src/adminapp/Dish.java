package adminapp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.FloatProperty;

public class Dish {
    private StringProperty nom;
    private StringProperty description;
    private StringProperty img;
    private FloatProperty prix;
    private StringProperty nom_res;

    public Dish(){
        this.nom = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.img = new SimpleStringProperty();
        this.prix = new SimpleFloatProperty();
        this.nom_res = new SimpleStringProperty();
    }

    //for id
    public String getNom(){
        return nom.get();
    }

    public void setNom(String name) {
        this.nom.set(name);
    }
    public StringProperty getDishNom(){
        return nom;
    }

    //for name
    public String getDescription(){
        return description.get();
    }

    public void setDescription(String desc) {
        this.description.set(desc);
    }

    public StringProperty getDishDescription(){
        return description;
    }

    //for price
    public Float getPrice(){
        return prix.get();
    }

    public void setPrice(Float price) {
        this.prix.set(price);
    }

    public FloatProperty getDishPrice(){
        return prix;
    }

    //for r_id
    public String getImage(){
        return img.get();
    }

    public void setImg(String image) {
        this.img.set(image);
    }

    public StringProperty getDishImg(){
        return img;
    }
    public String getNom_res(){
        return nom_res.get();
    }

    public void setNom_res(String name) {
        this.nom_res.set(name);
    }
    public StringProperty getDishNom_res(){
        return nom_res;
    }

}
