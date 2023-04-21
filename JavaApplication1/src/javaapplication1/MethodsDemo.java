package javaapplication1;

public class MethodsDemo {

    public static void main(String[] args) {
        System.out.println("Main Start");
        a();
        System.out.println("Main End");
    }

    public static void a() {
        System.out.println("A Start");
        b();
        System.out.println("A End");
    }

    public static void b() {
        System.out.println("B Start");
        c();
        System.out.println("B End");
    }

    public static void c() {
        System.out.println("C Start");
        int i = Integer.parseInt("5a7");
        System.out.println(i + 10);
        System.out.println("C End");
    }
}