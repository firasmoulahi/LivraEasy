/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Driver;
class LargeTruck extends Vehicule {
    private int cargoCapacity;

    public LargeTruck(String licensePlate, String model,String typev, int year, int cargoCapacity) {
        super( licensePlate,  model,  typev ,  year);
        this.cargoCapacity = cargoCapacity;
    }

    // Getter and Setter for specific properties of LargeTruck

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }
}