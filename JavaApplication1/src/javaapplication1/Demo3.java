package javaapplication1;

public class Demo3 {

    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8, 10, 13, 15};
        int arr1[] = {8, 13};
        boolean bool = false;
        int count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                count ++;
                if (arr[i] == arr1[j]) {
                    bool = true;
                }
            }
            System.out.println(arr[i] + " is " + bool);
            bool = false;
        }
    }
}
