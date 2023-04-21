package in.bassure.training.batch7.java.inheritance;

public class AnimalUtilities {

    public static void compete(Animal a, Animal b) {
        System.out.println(a.getName() + " AND " + b.getName()
                + "! Are COMPETING");

        System.out.println(a.move(100) + " AND " + b.move(100)
                + "! Are MOVING in COMPETION");
    }
}
