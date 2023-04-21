package javaapplication1.Inheritance.DeepCopy;

import java.io.Serializable;

public class Car implements Cloneable,Serializable {

    private String brandName;
    private String color;
    
    Engine engine = null;
    
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public Car(String brandName, String color, Engine engine) {
        this.brandName = brandName;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" + "brandName = " + brandName + " , color = " + color + " } ; Engine : { "+engine+" }";
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
        Car copCar = (Car) super.clone();
        copCar.engine = (Engine) this.engine.clone();
        return copCar;
    }

}
