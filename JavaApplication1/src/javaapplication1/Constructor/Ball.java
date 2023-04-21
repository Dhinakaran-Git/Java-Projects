package javaapplication1.Constructor;

import java.util.*;

public class Ball {

    private String brand;
    private String metrial;
    private final double price;
    private String color;
    private String ballType;

    public Ball() {
        brand = "Cosco";
        metrial = "Cork";
        ballType = "Critket ball";
        price = 200.0;
        color = "white";
    }

    public Ball(String brand, String ballType, double price) {
        this.brand = brand;
        this.price = price;
        this.ballType = ballType;
    }

    public Ball(String ballType) {
        this.ballType = ballType;
        this.price = 90;
    }

    public Ball(String brand, String ballType, String metrial, double price, String color) {
        this.brand = brand;
        this.metrial = metrial;
        this.price = price;
        this.color = color;
        this.ballType = ballType;
    }

    @Override
    public String toString() {
        return "brand : " + brand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this.hashCode() == obj.hashCode()) {
            return true;
        }
        return false;
    }
    
    

    void displayBall() {
        System.out.println("Brand : " + brand);
        System.out.println("Ball Type : " + ballType);
        System.out.println("Price : " + price);
        System.out.println("Metrial : " + metrial);
        System.out.println("Color : " + color);
    }
}
