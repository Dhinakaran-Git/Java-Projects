package in.bassure.training.batch7.java;

public class Chair {

    private double price;
    public final String MATERIAL;
    private String brand;

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

//    {
//        System.out.println("It's Chair2: " + new Date().getTime());
//    }
//    
//    {
//        System.out.println("It's Chair: " + new Date().getTime());
//    }
    {
        price = 800;
        brand = "Nilkamal";
    }

    public Chair() {
        MATERIAL = "Wooden";
//        price = 800;
//        brand = "Nilkamal";
    }

    public Chair(String MATERIAL) {
        this.MATERIAL = MATERIAL;
//        price = 800;
//        brand = "Nilkamal";
    }

    public Chair(String MATERIAL, String brand) {
        this.MATERIAL = MATERIAL;
        this.brand = brand;
//        price = 800;
    }

    public Chair(double price) {
        this.price = price;
        this.MATERIAL = "Plastic";
    }

    @Override
    public String toString() {
        return "Chair{" + "price=" + price + ", MATERIAL=" + MATERIAL + ", brand=" + brand + '}';
    }
    
    
}
