/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Driver;

/**
 *
 * @author firas
 */
class LargeTruckAction implements VehicleAction {
    @Override
    public void performAction(Vehicule vehicle) {
        if (vehicle instanceof LargeTruck) {
            LargeTruck largeTruck = (LargeTruck) vehicle;
            System.out.println("LargeTruck with license plate " + largeTruck.getLicensePlate() +
                    " is performing a specific action.");
        }
    }
}
