package javaapplication1;

public class Palindrome {

    public static void main(String[] args) {
        String str = "malayalam";
        boolean bool = true;
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                bool = false;
                break;
            }
        }
        if (bool) {
            System.out.println("Is Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

}
