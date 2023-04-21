package javaapplication1.ThisSuper_and_Constarctor_Chaining;

import javaapplication1.ThisSuper_and_Constarctor_Chaining.Cat;

public class Tiger extends Cat {

public Tiger() {
        this("Just Tiger");
    }

    public Tiger(String name) {
        super(name);
    }

    public String move(int distance) {
        return "Tiger moving: " + distance;
    }

    public void hunt() {
        System.out.println("Tiger Hunting");
    }

    public String whatCanYouDo() {

        return super.whatCanYouDo() + ", " + "I Can Roar";
    }

    public static void whoAmI() {
        System.out.println("I Am Tiger");
    }
}
