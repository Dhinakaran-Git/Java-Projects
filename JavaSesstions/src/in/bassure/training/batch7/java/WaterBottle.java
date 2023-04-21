package in.bassure.training.batch7.java;

public class WaterBottle implements Comparable<WaterBottle> {

    @Override
    public int compareTo(WaterBottle that) {
        if (this.CAPACITY < that.CAPACITY) {
            return -1;
        } else if (this.CAPACITY > that.CAPACITY) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("WB[Brand: %s, Capacity: %f]",
                this.BRAND_NAME, this.CAPACITY);
    }

    public final String BRAND_NAME;
    private double price;
    public final double CAPACITY;
    private double currentCapacity;
    public final String MATERIAL;

    public WaterBottle() {
        CAPACITY = 1000;
        BRAND_NAME = "Bisleri";
        price = 20;
        currentCapacity = CAPACITY;
        MATERIAL = "Plastic";
    }

    public WaterBottle(String BRAND_NAME, double CAPACITY) {
        this.BRAND_NAME = BRAND_NAME;
        this.CAPACITY = CAPACITY;
        price = 80;
        currentCapacity = 0;
        MATERIAL = "Plastic";
    }

    public WaterBottle(String brandName, double price, double capacity, double currentCapacity, String material) {
        this.BRAND_NAME = brandName;
        this.price = price;
        this.CAPACITY = capacity;
        this.currentCapacity = currentCapacity;
        this.MATERIAL = material;
    }

//    public double capacity(){
//        return CAPACITY;
//    }
    public void consume(double qty) throws WaterBottleConsumeException { //throws IllegalArgumentException {
        if (qty > this.getCurrentCapacity()) {
            //throw new IllegalArgumentException("Not enough water");
            throw new WaterBottleConsumeException("Not enough water");
        }
        currentCapacity -= qty;
    }

    public void fill(double value) throws WaterBottleFillException { //throws IllegalArgumentException {
        if (value < 0.0) {
            //throw new IllegalArgumentException(value + ", Negative fill value is invalid");
            throw new WaterBottleFillException(value + ", Negative fill value is invalid");
        } else if (value > CAPACITY - currentCapacity) {
            //throw new IllegalArgumentException(value + ", Possibility of Overflow");
            throw new WaterBottleFillException(value + ", Possibility of Overlow");
        }
        currentCapacity += value;
    }

    public void fill2(double value) {
        if (value < 0.0) {
            System.out.println("Invalid fill operation");
            return;
        } else if (value > CAPACITY - currentCapacity) {
            currentCapacity = CAPACITY;
            System.out.println("Overflow happened");
            return;
        }
        currentCapacity = value;
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
