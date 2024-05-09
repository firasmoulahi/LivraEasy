/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Driver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface
    interface DriverAction {
    void performAction(Driver driver);
}

class Driver {
    private String username;
    private String name;
    private String fname;
    private String pwd;
    private boolean isBusy;

    public Driver(String username, String name, String fname, String pwd) {
        this.username= username;
        this.name = name;
        this.fname = fname;
        this.isBusy = false;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getFname() {
        return fname;
    }

    public String getPwd() {
        return pwd;
    }

    public boolean isIsBusy() {
        return isBusy;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setIsBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }

  

    public void executeAction(DriverAction action) {
        action.performAction(this);
    }

    @Override
    public String toString() {
        return "Driver{" + "username=" + username + ", name=" + name + ", fname=" + fname + ", pwd=" + pwd + ", isBusy=" + isBusy + '}';
    }

    

class FoodDeliveryAction implements DriverAction {
    @Override
    public void performAction(Driver driver) {
        System.out.println("Driver " + driver.getName() + " is delivering food.");
        driver.setIsBusy(true);
    }
}

class ItemDeliveryAction implements DriverAction {
    @Override
    public void performAction(Driver driver) {
        System.out.println("Driver " + driver.getName() + " is delivering items.");
        driver.setIsBusy(true);
    }
}


}
