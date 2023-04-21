
public class PassByValuesDemo extends Object{

    public static void main(String[] args) {
        int i = 10, j = 20;

        System.out.println(i + " i " + j);
        sawp(i, j);
        System.out.println(i + " i " + j);
    }

    public static void sawp(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

}
