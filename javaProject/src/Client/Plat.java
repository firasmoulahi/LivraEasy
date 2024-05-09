package Client;

/**
 * Represents a plat with a name, description, and price.
 */
public class Plat implements Comparable<Plat> {
    private String nom;
    private String description;
    private float prix;

    // Constructor and other existing methods...
    
    public Plat(String nom, String description, float prix){
        this.nom=nom;
        this.description=description;
        this.prix=prix;
    
    
    }
    
    
    public String getNom(){
    
    return this.nom;
    }
    
    public float getPrix(){
    
    return this.prix;
    }
    
    
    @Override
    public int compareTo(Plat other) {
        // Compare plats based on their prices
        return Float.compare(this.prix, other.prix);
    }

    /**
     * Returns a string representation of the plat.
     * @return A string representation.
     */
    @Override
    public String toString() {
        return "Plat{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                '}';
    }
}
