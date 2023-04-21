package com.java.practices;

public class ProductPrice {

    static double price = 1500;
    static double dis = 22;

    public static void main(String[] args) {
        System.out.println(discount(89, 20));
    }

    public static double discount(double price, double dis) {
        return price - (price * dis) / 100;
    }
}
