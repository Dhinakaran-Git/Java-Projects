package com.java.practices;

import java.util.Objects;

public class NodeStack {

    private Node head;
    private int count;

    public NodeStack() {
        head = null;
        count = 0;
    }

    public void print() {
        Node temp = head;
        while (Objects.nonNull(temp)) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public boolean push(int data) {
        head = new Node(data, head);
        count++;
        return true;
    }

    public int pop() {
        if (Objects.nonNull(head)) {
            Node temp = head;
            head = temp.next;
            temp.next = null;
            count--;
            return temp.data;
        }
        System.out.println("Stack is Empty");
        return -1;
    }

    public int peak() {
        if (head != null) {
            return head.data;
        }
        System.out.println("Stack is Empty");
        return -1;
    }

    public int size() {
        return count;
    }

    private class Node {

        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
