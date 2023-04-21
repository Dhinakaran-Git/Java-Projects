package javaapplication1.ThisSuper_and_Constarctor_Chaining;

public abstract class Animal {

    private String name;

    public Animal() {
        this("Just Animal");
    }

    public Animal(String name) {
        this.name = name;
    }

    public abstract String move(int distance);
//    public String move(int distance){
//       return "Animal moving: " + distance;
//    }

    public String whatCanYouDo() {
        return "I Can Move";
    }

    public static void whoAmI() {
        System.out.println("I Am Animal");
    }

    public String getName() {
        return name;
    }
}
