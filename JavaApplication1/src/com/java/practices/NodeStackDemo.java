package com.java.practices;

public class NodeStackDemo {

    public static void main(String[] args) {
        NodeStack ns = new NodeStack();

        ns.push(20);
        ns.push(21);
        ns.push(22);
        ns.push(23);
        ns.push(24);
        
        
        System.out.println(ns.pop());
        
        ns.peak();
    }

}
