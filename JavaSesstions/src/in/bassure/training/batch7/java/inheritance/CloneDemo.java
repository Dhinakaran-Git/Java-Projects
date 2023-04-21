package in.bassure.training.batch7.java.inheritance;

public class CloneDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Car c1 = new Car("KIA", "Red", new Engine("Petrol", "100Nm", 1600));
        Car c2 = c1.clone();

        System.out.println(c1);
        System.out.println(c2);
        System.out.println("~".repeat(c1.toString().length()));
        c2.engine.getCrankShaft().setBrand("Yamaha");

        System.out.println(c1);
        System.out.println(c2);
    }

    public static void main1(String[] args) throws Exception {

        Engine e1 = new Engine("Petrol", "100Nm", 1600);
        Car c1 = new Car("KIA", "Red", e1);
        Car c2 = c1.clone();

        System.out.println(c1);
        //System.out.println(c1.engine);
        System.out.println(c2);
        //System.out.println(c2.engine);
        System.out.println("*************************");

        c1.brandName = "Toyota";
        c1.engine.fuelType = "Diesel";
        c1.engine.power = 2300;

        System.out.println(c1);
        //System.out.println(c1.engine);
        System.out.println(c2);
        //System.out.println(c2.engine);

    }
}
