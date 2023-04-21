/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1.Constructor;

/**
 *
 * @author bas200137
 */
public class Chair {

    private double price;
    public final String METERIAL;
    private String brand;

    public Chair() {
        METERIAL = "Wooden";
        price = 400;
        brand = "Nilkamal";
    }

    public Chair(String METERIAL) {
        this.METERIAL = METERIAL;
        price = 600;
        brand = "Nilkamal";
    }

    public Chair(String MATERIAL, String brand) {
        this.METERIAL = MATERIAL;
        this.brand = brand;
    }
}
