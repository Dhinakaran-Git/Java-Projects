package in.bassure.training.batch7.java;

public class WaterBottleDemo {

    public static void main(String[] args) {
        WaterBottle a = new WaterBottle("Tupperweare", 1000);
        a.fill(800);
        a.consume(450);
        a.fill(250);
        a.consume(700);
    }

    public static void main4(String[] args) {
        WaterBottle a = new WaterBottle("Tupperweare", 1000);

        System.out.println(a.getCurrentCapacity());

        try {
            a.fill(480);
            System.out.println(a.getCurrentCapacity());

            a.fill(200);
            System.out.println(a.getCurrentCapacity());
            a.fill(300);
            System.out.println(a.getCurrentCapacity());
            a.fill(50);
        } catch (IllegalArgumentException iae) {
            System.err.println("ISSUE: " + iae.getMessage());
        }
        System.out.println(a.getCurrentCapacity());
    }

    public static void main3(String[] args) {
        WaterBottle a = new WaterBottle("Tupperware", 2000);
    }

    public static void main2(String[] args) {
        WaterBottle a = new WaterBottle("Cello", 125.5, 2000, 0, "Plastic");
        System.out.println(a.isEmpty());
        System.out.println(a.CAPACITY);

        a.fill(1200);
        System.out.println(a.getCurrentCapacity());
        a.fill(1000);
        System.out.println(a.getCurrentCapacity());
    }

    public static void main1(String[] args) {
        WaterBottle a = new WaterBottle();

        System.out.println(a.isEmpty());

        //a.currentCapacity = 0.24;
        a.fill(-0.24);
        System.out.println(a.isEmpty());
        //System.out.println(a.currentCapacity);
        System.out.println(a.getCurrentCapacity());

        //a.currentCapacity = -2.4;
    }

}
