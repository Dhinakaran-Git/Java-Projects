/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author bas200137
 */
public class JavaApplication1 {

    public static void \u006D\u0061\u0069\u006E(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("10*" + i + "=" + i * 10);
        }
        main1();
    }

    public static void main1() {
        char t = '\u0061';   //char t='a'
        System.out.println(t);

        byte b = 26;
        short s = 300;
        int i = 12345678;
        
        long l = 45678901234L;
        float f = 456.789F;
        
        double d = 325691123.456789124;
        boolean bool =true;
        
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(bool);

    }
}
