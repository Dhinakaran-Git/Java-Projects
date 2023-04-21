
import java.awt.Point;


public class PassByValueDemo {

    public static void main2(String[] args) {
        Point a = new Point(10, 20);
        
        System.out.println(a.x + " # " + a.y);
        swap(a);
        System.out.println(a.x + " # " + a.y);
    }
    
    public static void swap(Point t){
        int temp = t.x;
        t.x = t.y;
        t.y = temp;
    }
    
    public static void main(String[] args) {
        int i = 10, j = 20;
        
        System.out.println(i + " # " + j);
        swap(i, j);
        System.out.println(i + " # " + j);
    }
    
    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }
}
