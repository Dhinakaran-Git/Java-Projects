package javaapplication1;

public class DemoArray {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println("The Largest Number is "+max);
    }
}
