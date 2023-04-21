package javaapplication1.Collection;

public class MyTreeDemo {

    public static void main(String[] args) {
        MyTree mt = new MyTree();
        mt.add(55);
        mt.add(44);
        mt.add(4);
        mt.add(6);
        mt.add(2);
        mt.add(7);
        System.out.println("isExists  :  " +mt.exists(3));
        mt.orderIn();
    }
}