package com.java.practices;

public class MathOperation {

    int first;
    int second;

    public static int clac(int a, String b, int c) {
        if (b == "+") {
            return a + c;
        } else if (b == "/") {
            return a / c;
        } else if (b == "-") {
            return a - c;
        }
        return 0;
    }

    public static String nameString(String newStr) {
        String str = "progrmming";
        return newStr + str;
    }

    public static int programmers(int a, int b, int c) {
        if (a < b && b > c) {
            return a - b;
        } else if (b < c && b > c) {
            return b - c;
        }
        return 0;
    }

    public static int findVowels(String word) {
        char[] ch = word.toCharArray();
        int count = 0;
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u' || ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U') {
                count++;
            }
        }
        return count;
    }

    public static String swap(String str) {
        String[] newStr = str.split(" ");
        String join = "";
        for (int i = 0; i < newStr.length - 1; i++) {
            join = newStr[i + 1] + " " + newStr[i];
        }
        return join;
    }

    public static int[] calculateScroce(String str) {
        char[] ch = str.toCharArray();
        int[] count = {0};
        for (int i = 0; i < ch.length - 1; i++) {
            for (int j = 1; j < ch.length - 1; j++) {
                if (ch[i] == ch[j]) {

                }
            }
        }
        return count;
    }

    public static int[] arryOfMultiples(int num, int index) {
        int[] newArr = new int[index];
        for (int i = 0; i < index; i++) {
            newArr[i] = (i + 1) * num;
        }
        return newArr;
    }

    public static boolean partyAnalysis(int val) {
//        int temp = val;
        int total = 0;
        while (val != 0) {
            int rem = val % 10;
            total += rem;
            val = val / 10;
        }
        if (total % 2 == 0 && val % 2 == 0 || total % 2 != 0 && val % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int warOfNumbers(int[] arr) {
        int odd = 0;
        int even = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                even = even + arr[i];
            } else {
                odd = odd + arr[i];
            }
        }
        if (odd > even) {
            return odd - even;

        } else {
            return even - odd;
        }
    }

    public static void getDecimalPlaces(String str) {
//        char[] ch = str.toCharArray();
//        int count = 0;
//        for (int i = 0; i < ch.length; i++) {
//            System.out.println(ch[i]);
//        }
        String[] count = str.toString().split("\\.");
        System.out.println(count[1].length());
    }
    
//    public static void 

    public static void main(String[] args) {

//        System.out.println(MathOperation.clac(20, "-", 10));
//        System.out.println(MathOperation.nameString("Mossa"));
//        System.out.println(MathOperation.programmers(10, 20, 340));
//        System.out.println(MathOperation.findVowels("Palm"));
//        System.out.println(MathOperation.swap("moosa moo"));
//        System.out.println(calculateScroce("AABCCC"));
//        int[] x = arryOfMultiples(7, 5);
//        for (int i = 0; i < x.length; i++) {
//            System.out.print(x[i] + ",");
//        }
//        System.out.println(partyAnalysis(258));
        int[] arr = {2, 8, 7, 5};
        System.out.println(warOfNumbers(arr));

        getDecimalPlaces("13.003");

    }
}
