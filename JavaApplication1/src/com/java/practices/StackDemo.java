package com.java.practices;

public class StackDemo {

    public static void main(String[] args) {
        ArrayStack stackDemo = new ArrayStack();
        stackDemo.push(12);
        stackDemo.push(13);
        stackDemo.push(14);
        stackDemo.push(15);
        stackDemo.pop();
        stackDemo.peek();
        stackDemo.show();
        
        
    }
}
