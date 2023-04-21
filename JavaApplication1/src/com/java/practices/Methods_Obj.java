package com.java.practices;

public class Methods_Obj {

    public static void m4() {
//        m2(); // not possible it's non static methods 
        System.out.println("m4");

    }

    public static void m1() {
        m4();
        System.out.println("m1");

    }

    public void m2() {
//        m4();
        System.out.println("m2");
    }

    public static void main(String[] args) {
        Methods_Obj m = new Methods_Obj();
        Methods_Obj.m1();
        m.m4();
    }
}
