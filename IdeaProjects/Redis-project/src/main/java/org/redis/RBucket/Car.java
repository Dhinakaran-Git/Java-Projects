package org.redis.RBucket;


public class Car {
    private int id;
    private String brand;
    private String enginType;

    public Car() {
    }

    public Car(int id, String brand, String enginType) {
        this.id = id;
        this.brand = brand;
        this.enginType = enginType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", enginType='" + enginType + '\'' +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEnginType() {
        return enginType;
    }

    public void setEnginType(String enginType) {
        this.enginType = enginType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
