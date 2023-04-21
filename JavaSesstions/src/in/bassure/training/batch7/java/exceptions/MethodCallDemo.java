package in.bassure.training.batch7.java.exceptions;

import in.bassure.training.batch7.java.WaterBottleFillException;

public class MethodCallDemo {

    public static void main(String[] args) {
        System.out.println("Main Start");
        try {
            a();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Main End");
    }

    public static void a() {
        System.out.println("A Start");

        b();

        System.out.println("A End");
    }

    public static void b() {
        System.out.println("B Start");

        try {
            c();
        } catch (NumberFormatException nfe) {
            throw new WaterBottleFillException("Hey, It's not WaterBottle", nfe);
        }

        System.out.println("B End");
    }

    public static void c() {
        System.out.println("C Start");

        int i = Integer.parseInt("5a7");
        System.out.println(i + 10);

        System.out.println("C End");
    }

}
