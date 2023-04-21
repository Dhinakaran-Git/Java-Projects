package javaapplication1;  

public class Demo2 {

    public static void main(String[] args) {
        int a[] = {24, 89, 73, 25, 61};
        int temp = 73;
        int count = 0;
        boolean found = false;

        for (int i = 0; i < a.length; i++) {
            count++;
            if (a[i] == temp) {
                found = true;
                break;
            }
        }
        System.out.println(temp + " exists: " + found);
        System.out.println(count);
    }

}
