package javaapplication1.Interface;

public class SamsungRemote extends Object implements Remote{

    @Override
    public boolean switchOn() {
        System.out.println("Swithing on the remote");
        return true;
    }

    @Override
    public boolean swithOff() {
        System.out.println("Switching off the remote");
        return false;
    }
    
}
