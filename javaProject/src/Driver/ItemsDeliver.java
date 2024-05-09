/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Driver;

public class ItemsDeliver extends Driver {
    private int maxLoadCapacity;

    public ItemsDeliver(String username, String name, String fname, String pwd, int maxLoadCapacity) {
        super( username,  name,  fname,  pwd);
        this.maxLoadCapacity = maxLoadCapacity;
    }

    // Getter and Setter for specific properties of ItemsDeliver

    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public void setMaxLoadCapacity(int maxLoadCapacity) {
        this.maxLoadCapacity = maxLoadCapacity;
    }
    
    
    
    
}

