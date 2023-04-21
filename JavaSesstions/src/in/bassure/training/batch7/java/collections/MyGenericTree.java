package in.bassure.training.batch7.java.collections;

import java.util.Objects;

public class MyGenericTree<T extends Comparable> {

    private TreeNode<T> root;

    public void add(T value) {
        TreeNode<T> temp = root;

        while (Objects.nonNull(temp)) {
            //if (value < temp.value) {
            if (value.compareTo(temp.value) < 0) {
                if (Objects.nonNull(temp.leftNode)) {
                    temp = temp.leftNode;
                    continue;
                }
                break;
            } else {
                if (Objects.nonNull(temp.rightNode)) {
                    temp = temp.rightNode;
                    continue;
                }
                break;
            }
        }

        TreeNode current = new TreeNode(value);
        if (Objects.isNull(temp)) {
            root = current;
        } else if (value.compareTo(temp.value) < 0) {
            temp.leftNode = current;
        } else {
            temp.rightNode = current;
        }
    }

    public boolean exists(T value) {
        TreeNode<T> current = root;
        while (Objects.nonNull(current)) {
            if (Objects.equals(current.value, value)) {
                return true;
            } else if (value.compareTo(current.value) < 0) {
                current = current.leftNode;
            } else {
                current = current.rightNode;
            }
        }
        return false;
    }

    public void printInOrder() {
        if (Objects.isNull(root)) {
            System.out.println("Tree is Empty");
            return;
        }
        System.out.println("[");
        _printInOrder(root);
        System.out.println("]");
    }

    private void _printInOrder(TreeNode current) {
        if (Objects.nonNull(current.leftNode)) {
            _printInOrder(current.leftNode);
        }
        System.out.println("\t" + current.value + ",");
        if (Objects.nonNull(current.rightNode)) {
            _printInOrder(current.rightNode);
        }
    }

    private static class TreeNode<T> {

        private T value;
        private TreeNode<T> leftNode;
        private TreeNode<T> rightNode;

        public TreeNode(T value) {
            this.value = value;
        }
    }
}
