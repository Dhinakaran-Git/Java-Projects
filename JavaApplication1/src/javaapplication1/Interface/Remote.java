package javaapplication1.Interface;

public interface Remote {

//    we can use static and non-static methods
    public default void switchOn1(){
        System.out.println("Swtching on the Device");
    }
    
    public static void switchOff1(){
        System.out.println("Swtching off the Device");
    }
    
    abstract boolean switchOn();
    boolean swithOff();
}