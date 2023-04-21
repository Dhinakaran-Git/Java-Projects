package com.java.practices;

public class Animal {

    int chicken = 2;
    int cow = 4;
    int pigs = 4;

    public int check(int chicken, int cow, int pig) {
        int totalchicken = chicken * 2;
        int totalcow = cow * 4;
        int totalpig = pig * 4;
        return totalchicken + totalcow + totalpig;
    }
    
    public static void main(String[] args) {
        Animal a = new Animal();
        System.out.println(a.check(2, 4, 4));
    }
}
