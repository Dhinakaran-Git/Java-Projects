package in.bassure.training.batch7.java;

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
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public int length() {
        Node temp = head;
        int size = 0;

        while (Objects.nonNull(temp)) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    public int peek() {
        //if(Objects.nonNull(head)){
        if (head != null) {
            return head.data;
        }

        System.out.println("Stack Empty");
        return -1;
    }

    public int pop() {
        if (Objects.nonNull(head)) {
            Node temp = head;
            head = temp.next;
            temp.next = null;
            count--;
            return temp.data;
        }

        System.out.println("Stack Empty");
        return -1;
    }

    public boolean push(int data) {
        head = new Node(data, head);
        count++;
        return true;
    }

    public int size() {
        return count;
    }

    private static class Node {

        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
