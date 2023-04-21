package in.bassure.training.batch7.java.inheritance;

public class CrankShaft implements Cloneable {

    private String brand;
    private double price;

    public CrankShaft(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("CrankShaft[Brand: %s, Price: %f]", brand, price);
    }

    @Override
    public CrankShaft clone() throws CloneNotSupportedException {
        return (CrankShaft) super.clone();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
