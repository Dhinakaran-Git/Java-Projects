
public class MethodsDemo {

    public static void main(String[] args) {
        int i = 25, j = 20, k = 18, m = 31;
        int result;

        result = max(m, max(i, max(j, k)));
        System.out.println("Result: " + result);

        int x = 14;

        result = 10 * max(i, j) / 12 - x;
        System.out.println(result);
    }

    public static void main1(String[] args) {
        int result = max(10, 8);
        System.out.println("MAX of 10 and 8 is: " + result);

        int i = 15, j = 25;
        result = max(i, j);
        System.out.println("MAX of " + i + " and " + j + ": " + result);
    }

    public static void print(String a) {

    }
    
    public static void print(int a, String b){
        
    }
    
    public static void print(String a, int b){
        
    }

    public static void print(int a) {

    }

    public static void print(double a) {

    }

    public static void print(boolean a) {

    }

    public static double max(double a, double b) {
        return a > b ? a : b;
    }

    public static int max(int a, int b) {
        //return a > b ? a : b;
        if (a > b) {
            return a;
        }
        return b;
    }

    int getRandomNumber() {
        return 1;
    }

    public static void print(long number) throws IllegalArgumentException {

    }
}
