package in.bassure.training.batch7.java.inheritance;

public interface Remote {

    public default void switchOn() {
        System.out.println("Swtching on the Device");
    }

    public static void whoAmI() {
        System.out.println("I am Remote, I can operate things from distance");
    }
}
