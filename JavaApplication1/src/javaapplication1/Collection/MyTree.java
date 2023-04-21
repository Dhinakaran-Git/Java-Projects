package javaapplication1.Collection;

import java.util.Objects;

public class MyTree<T> {

    TreeNode root;

    public MyTree() {
        this.root = null;
    }

    public void add(int data) {
        TreeNode current = new TreeNode(data);
        if (Objects.isNull(root)) {
            //first root value is root
            root = current;
        } else {
            TreeNode temp = root;
            while (true) {
                if (current.item < temp.item && Objects.nonNull(temp.left)) {
                    temp = temp.left;
                } else if (current.item >= temp.item && Objects.nonNull(temp.right)) {
                    temp = temp.right;
                } else {
                    break;
                }
            }
            if (current.item < temp.item) {
                temp.left = current;
            } else {
                temp.right = current;
            }
        }
        System.out.println(root);
    }

    public void orderIn() {
        printInOrder(root);
    }

    public void printInOrder(TreeNode current) {
        if (Objects.nonNull(current.left)) {
            printInOrder(current.left);
        }
        System.out.print(current.item + " ");
        if (Objects.nonNull(current.right)) {
            printInOrder(current.right);
        }
    }

    public boolean exists(int value) {
        TreeNode current = root;
        while (Objects.nonNull(current)) {
            if (current.item == value) {
                return true;
            } else if (current.item > value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }
}
