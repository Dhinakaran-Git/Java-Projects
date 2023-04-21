/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1.Constructor;

/**
 *
 * @author bas200137
 */
public class WaterBottleDemo {

    public static void main1(String[] args) {

        WaterBottle w1 = new WaterBottle();
        System.out.println(w1.isEmpty());

        w1.newFill(0.8);
        System.out.println(w1.getCurrentCapacity());
        System.out.println(w1.isEmpty());

    }

    public static void main(String[] args) {
        WaterBottle w2 = new WaterBottle("tubber", 2.0, 1.5, "thick");
        System.out.println(w2.capacity);
        System.out.println(w2.isEmpty());
        w2.newFill(1.7);
        System.out.println(w2.capacity());
        System.out.println(w2.isEmpty());
        System.out.println(w2.getCurrentCapacity());
    }
}
