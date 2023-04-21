package in.bassure.training.batch7.java;

import java.util.Objects;

public class NodeStackV3<T> {

    private Node<T> head;
    private int count;

    public NodeStackV3() {
        head = null;
        count = 0;
    }

    public void print() {
        Node<T> temp = head;
        while (Objects.nonNull(temp)) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public int length() {
        Node<T> temp = head;
        int size = 0;

        while (Objects.nonNull(temp)) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    public T peek() {
        //if(Objects.nonNull(head)){
        if (head != null) {
            return head.data;
        }

        System.out.println("Stack Empty");
        return null;
    }

    public T pop() {
        if (Objects.nonNull(head)) {
            Node<T> temp = head;
            head = temp.next;
            temp.next = null;
            count--;
            return temp.data;
        }

        System.out.println("Stack Empty");
        return null;
    }

    public boolean push(T data) {
        head = new Node(data, head);
        count++;
        return true;
    }

    public int size() {
        return count;
    }

    private static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
