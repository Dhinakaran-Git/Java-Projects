package in.bassure.training.batch7.java;

public class Laptop {

    private final String BRAND;
    private double price;
    private final double SIZE;
    private double ramSize;

    public Laptop() {
        this("Dell");
    }

    public Laptop(String brand) {
        this(brand, 40000);
    }

    public Laptop(String brand, double price) {
        super();
        this.BRAND = brand;
        this.price = price;
        this.SIZE = 14;
        ramSize = 8;
    }

//    public Laptop() {
//        this.BRAND = "Dell";
//        this.SIZE = 14;
//        price = 40000;
//        ramSize = 8;
//    }
//
//    public Laptop(String brand) {
//        this.BRAND = brand;
//        this.SIZE = 14;
//        price = 40000;
//        ramSize = 8;
//    }
//
//    public Laptop(String brand, double price) {
//        this.BRAND = brand;
//        this.price = price;
//        this.SIZE = 14;
//        ramSize = 8;
//    }
    @Override
    public String toString() {
        return String.format("Laptop[%s, %9.2f, %3.1f, %4.1f]",
                BRAND, price, SIZE, ramSize);
    }
}
