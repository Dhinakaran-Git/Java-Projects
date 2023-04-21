package com.java.practices;

import java.util.Arrays;

public class ArrayStack {

    int[] stack = new int[0];
    int top = -1;

    void show() {
        for (int i = 0; i <= stack.length - 1; i++) {
            if (stack[i] == 0) {
                break;
            }
            System.out.print(stack[i] + " ");
        }
    }

    void push(int val) {

        int[] newStack = Arrays.copyOf(stack, stack.length + 1);
        newStack[++top] = val;
        stack = newStack;

//        if (top == (stack.length - 1) - 1) {
//            System.out.println("OVERFLOW");
//        } else {
//            top++;
//            stack[top] = a;
//        }
    }

    void pop() {
        if (top != -1) {
            int[] newArr = Arrays.copyOf(stack, stack.length - 1);
            stack = newArr;
            newArr = null;
        } else {
            System.out.println("Stack is empty...!");
        }
    }

    void peek() {
        if (top != -1) {
            System.out.println(stack[top] + " is the number that will be popped next");

        } else {
            System.out.println("UNDERFLOW");
        }
    }

    void size() {
        System.out.println((top + 1) + "total size ");
    }
}
