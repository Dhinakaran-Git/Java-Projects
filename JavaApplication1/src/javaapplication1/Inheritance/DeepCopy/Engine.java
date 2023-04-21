package javaapplication1.Inheritance.DeepCopy;

import java.io.Serializable;


public class Engine implements Cloneable,Serializable{
    private int power;
    private String fuelType;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Engine) super.clone(); 
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Engine(int power, String fuelType) {
        this.power = power;
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Power : " + power + " ,FuelType : " + fuelType;
    }
}
