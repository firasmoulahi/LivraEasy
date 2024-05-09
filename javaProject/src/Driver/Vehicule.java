/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Driver;
import java.util.ArrayList;
import java.util.List;

// Interface fonctionnelle générique pour les actions de véhicules
@FunctionalInterface
interface VehicleAction {
    void performAction(Vehicule vehicle);
}

public class Vehicule {
    private String licensePlate;
    private String model;
    private String typev;
    private int year;

    public Vehicule(String licensePlate, String model, String typev, int year) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.typev = typev;
        this.year = year;
    }
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String typev) {
        this.typev = typev;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public String getTypev() {
        return typev;
    }

    // Getters and Setters
    public int getYear() {
        return year;
    }

    // ... (omis pour la concision)
    // Méthode pour exécuter une action sur le véhicule en utilisant l'interface fonctionnelle
    public void executeAction(VehicleAction action) {
        action.performAction(this);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", model='" + model + '\'' +
                ", type='" + typev + '\'' +
                ", year=" + year +
                '}';
    }
}




// Exemple d'action spécifique à LargeTruck

