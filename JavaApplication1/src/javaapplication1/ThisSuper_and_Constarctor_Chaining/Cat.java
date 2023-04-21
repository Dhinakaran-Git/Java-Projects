package javaapplication1.ThisSuper_and_Constarctor_Chaining;

import javaapplication1.ThisSuper_and_Constarctor_Chaining.Animal;

public class Cat extends Animal {

    public Cat() {
        this("Just Cat");
    }

    public Cat(String name) {
        super(name);
    }

    @Override
    public String move(int distance) {
        return "Cat moving: " + distance;
    }

    public String whatCanYouDo() {
        return super.whatCanYouDo() + ", " + "I Can Jump";
    }

    public static void whoAmI() {
        System.out.println("I Am Cat");
    }


}
