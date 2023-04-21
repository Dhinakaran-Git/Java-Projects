
public class PalindromeDemo {

    public static void main(String[] args) {
        String input = "raccaa";
        boolean palindrome = true;

        for (int i = 0, j = input.length() - 1; i <= j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                palindrome = false;
                break;
            }
        }

        if (palindrome) {
            System.out.println(input + ": is Palindrome");
        } else {
            System.out.println(input + ": is not Palindrome");
        }
    }

    public static void main1(String[] args) {
        String input = "pop";
        String reverse = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reverse += input.charAt(i);
        }

        if (input.equals(reverse)) {
            System.out.println(input + ": is Palindrome");
        } else {
            System.out.println(input + ": is not Palindrome");
        }
    }

}
