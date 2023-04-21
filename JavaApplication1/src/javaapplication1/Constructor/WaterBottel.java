/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1.Constructor;

/**
 *
 * @author bas200137
 */
class WaterBottle {

    public WaterBottle() {

    }

    public WaterBottle(String bn, double c, double p, String mt) {
        brandName = bn;
        capacity = c;
        price = p;
        metrial = mt;
    }

    public double capacity() {
        capacity = 2.5;
        return capacity;
    }

    String brandName;
    String color;
    String metrial;
    double price;
//TODO final double capacity;
    double capacity;
    private double currentCapacity;

    public void newFill(double value) {
        if (value < 0.0) {
            throw new IllegalArgumentException(value + "");
//            currentCapacity = 0.0;
//            System.out.println("Invalid fill Operation");
//            return;
        } else if (value > capacity) {
            throw new ArithmeticException(color);
//            currentCapacity = capacity;
//            System.out.println("You cannot fill more then the capacity");
        } else {
            currentCapacity = value;
        }
    }

    public double getCurrentCapacity() {
        return currentCapacity;
    }

    public boolean isEmpty() {
        if (currentCapacity > 0.0) {
            return false;
        }
        return true;
    }
}
