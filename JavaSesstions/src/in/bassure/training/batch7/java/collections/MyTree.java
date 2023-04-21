package in.bassure.training.batch7.java.collections;

import java.util.Objects;

public class MyTree {

    private TreeNode root;

    public void add(Integer value) {
        TreeNode temp = root;

        while (Objects.nonNull(temp)) {
            if (value < temp.value) {
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
        } else if (value < temp.value) {
            temp.leftNode = current;
        } else {
            temp.rightNode = current;
        }
    }

    public boolean exists(Integer value) {
        TreeNode current = root;
        while (Objects.nonNull(current)) {
            if (Objects.equals(current.value, value)) {
                return true;
            } else if (value < current.value) {
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
        _printInOrder(root);
        System.out.println("");
    }

    private void _printInOrder(TreeNode current) {
        if (Objects.nonNull(current.leftNode)) {
            _printInOrder(current.leftNode);
        }
        System.out.print(current.value + " ");
        if (Objects.nonNull(current.rightNode)) {
            _printInOrder(current.rightNode);
        }
    }

    private static class TreeNode {

        private Integer value;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(Integer value) {
            this.value = value;
        }
    }
}
