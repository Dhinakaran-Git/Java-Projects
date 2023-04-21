package javaapplication1;

final class Com {

    private final double re;
    private final double im;

    public Com(double d, double i) {
        this.re = d;
        this.im = i;
    }

//    @Override
//    public String toString() {
//        return "com{" + "re=" + re + ", im=" + im + '}';
//    }
}

public class Main {

    public static void main(String[] args) {
        Com c = new Com(10, 20);
        System.out.println(c);
    }
}
