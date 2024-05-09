/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Driver;

public class FoodDeliver extends Driver {
    private String deliveryArea;

    public FoodDeliver(String username, String name, String fname, String pwd, String deliveryArea) {
        super(username,  name,  fname,  pwd);
        this.deliveryArea = deliveryArea;
    }

    // Getter and Setter for specific properties of FoodDeliver

    public String getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }
}
