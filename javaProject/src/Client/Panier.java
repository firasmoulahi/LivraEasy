/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 *
 * @author firas
 */
public class Panier  {
    private int id;
    private ArrayList<Plat> plats;

    public Panier(int id) {
        this.id = id;
        this.plats = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Plat> getPlats() {
        return plats;
    }

    public void ajouterPlat(Plat plat) {
        plats.add(plat);
        Collections.sort(plats);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Panier ID: ").append(id).append("\n");
        sb.append("Plats in the Panier:\n");

        String platDetails = plats.stream()
                .map(plat -> "Nom: " + plat.getNom() + ", Prix: " + plat.getPrix())
                .collect(Collectors.joining("\n"));

        sb.append(platDetails);

        return sb.toString();
    }
}
