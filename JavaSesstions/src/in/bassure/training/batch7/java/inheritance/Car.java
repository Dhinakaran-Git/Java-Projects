package in.bassure.training.batch7.java.inheritance;

public class Car implements Cloneable {

    public String brandName;
    public String color;

    public Engine engine;

    {
        engine = new Engine(null, null, 0);
    }

    public Car(String brandName, String color) {
        this.brandName = brandName;
        this.color = color;
    }

    public Car(String brandName, String color, Engine engine) {
        this.brandName = brandName;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car[Brand Name: " + brandName + ", Color: " + color + ", Engine: "
                + engine + "]";
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        Car copy = (Car) super.clone();
        copy.engine = (Engine) this.engine.clone();
//        copy.engine = new Engine(copy.engine.fuelType,
//                copy.engine.torque, copy.engine.power);
        return copy;
    }

}
