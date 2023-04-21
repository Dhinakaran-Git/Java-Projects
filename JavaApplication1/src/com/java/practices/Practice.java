package com.java.practices;

public class Practice {

    public static void main17(String[] args) {
        String s = "james cre5ted java";

        for (int i = 4; i < s.length(); i += 5) {
            int c1 = s.charAt(i);
            if (c1 >= 'A' && c1 <= 'Z' || c1 >= 'a' && c1 <= 'z') {
                System.out.println(s.charAt(i));
            }
        }
    }

//    reverse order 4th character
    public static void main16(String[] args) {
        String s = "james created java";
        for (int i = s.length() - 4; i >= 0; i -= 4) {
            System.out.println(s.charAt(i));
        }
    }

    public static void main15(String[] args) {
        String s = "james cre5ted java";
        String regx = "[0-9]";
        String replaced = s.replaceAll(regx, " ");
        for (int i = 4; i < s.length(); i += 5) {
            if (replaced.charAt(i) == ' ') {
                System.out.println(s.charAt(i));
            }
        }
    }

//    find 6th character
    public static void main19(String[] args) {
        String s = "james created java";
        for (int i = 0; i < s.length(); i++) {
            if (i % 6 == 5) {
                System.out.println(s.charAt(i));
            }
        }
    }
    
//    find 5th character
    public static void main14(String[] args) {
        String str = "I am Dhinakaran";
        for (int i = 4; i < str.length(); i += 5) {
            System.out.println(str.charAt(i));
        }
    }

//    find 4th character
    public static void main18(String[] args) {
        String str = "I am Dhinakaran";
        for (int i = 3; i < str.length(); i += 4) {
            System.out.println(str.charAt(i));
        }
    }

    public static void main13(String[] args) {
        String str = "I am Dhinakaran";
        StringBuilder s = new StringBuilder();

        System.out.print(s.append(str).reverse());
    }

//    To find sum of even every digits in the array
    public static void main11(String[] args) {
        int arr[] = {12, 23, 24, 3, 45};
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            while (temp != 0) {
                int rem = temp % 10;
                if (rem % 2 == 0) {
                    total = total + rem;
                }
                temp = temp / 10;
            }
        }
        System.out.println(total);
    }

//    search 3rd character in a given sentens
    public static void main10(String[] args) {
        String str = "I am Dhinakaran";
        for (int i = 2; i < str.length(); i += 3) {
            System.out.println(str.charAt(i));
        }
    }

//    count space
    public static void main9(String[] args) {
        String str = "I Love Java";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main7(String[] args) {
        String str = "I Love Java";
        str = str.trim();
        String arr[] = str.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > 2) {
                System.out.println(arr[i].charAt(2) + " ");
            }
        }
    }

//    String without space
    public static void main8(String[] args) {
        String str = "I Love Java";
        String[] str1 = str.split(" ");
        for (int i = 0; i < str1.length; i++) {
            System.out.print(str1[i]);
        }
    }

//    String reverse
    public static void main5(String[] args) {
        String str = "I Love Java";
        char ch[] = str.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            System.out.print(ch[i]);
        }
    }

//    Find First Largest Number
    public static void main4(String[] args) {
        int arr[] = {3, 4, 7, 3, 5, 8, 5, 8};
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(temp);
    }

//    Find without duplicate values from an array
    public static void main3(String[] args) {
        int arr[] = {3, 4, 7, 3, 5, 8, 5, 8};
        boolean find = false;
        System.out.print("Without Duplicate values from an array : ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    find = true;
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }

//    Find duplicate values from an array
    public static void main2(String[] args) {
        int arr[] = {3, 4, 7, 3, 5, 8, 5, 8};

        System.out.print("Duplicate values from an array : ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }

//    Decending array : 
    public static void main1(String[] args) {
        int arr[] = {2, 3, 4, 6, 10, 12, 14, 16, 32, 29};

        System.out.print("Decending array : ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

}
