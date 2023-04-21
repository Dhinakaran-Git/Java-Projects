package javaapplication1.Collection;

class TreeNode {

    int item;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key) {
        this.item = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "Node{" + "item=" + item + ", left=" + left + ", right=" + right + '}';
    }
}