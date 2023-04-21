/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1.Constructor;

/**
 *
 * @author bas200137
 */
public class BallDemo {

    public static void main(String[] args) {
        Ball b1 = new Ball();
//        b1.displayBall();
        System.out.println("----------------------");
        Ball b2 = new Ball("Nivia", "foodball", 350);
//        b2.displayBall();
        Ball b3 = new Ball();
        Ball b4 = new Ball();

        System.out.println(b2.toString());
        System.out.println(b2.hashCode());

    }
}
