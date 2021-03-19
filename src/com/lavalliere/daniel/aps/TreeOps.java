package com.lavalliere.daniel.aps;

public class TreeOps {

    private TreeNode root;

    public class TreeNode {
        int value;
        TreeNode prev;
        TreeNode next;
        int occurences;

        public TreeNode(int value) {
            this.value = value;
            this.occurences = 1;
        }
        public TreeNode(int value, TreeNode prev, TreeNode next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
            this.occurences = 1;
        }
    }

    public TreeOps() {
    }

    public void insert(int value) {
        TreeNode node = new TreeNode(value);
        if (root == null) {
            root = node;
        } else {
            insert(root, node);
        }
    }

    private void insert(TreeNode parent, TreeNode node) {
        if (parent.value == node.value) {
            parent.occurences++;
        } else if (parent.value > node.value) {
            if (parent.prev == null) {
                parent.prev = node;
            } else {
                insert(parent.prev, node);
            }
        } else {
            if (parent.next == null) {
                parent.next = node;
            } else {
                insert(parent.next, node);
            }
        }
    }


    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(TreeNode node, int value) {
        if (node == null) return false;
        if (node.value == value) return true;
        if (value < node.value) {
            return search(node.prev, value);
        } else {
            return search(node.next, value);
        }
    }

    public void inOrderTraversal() {
        if (root != null) inOrderTraversal(root);
    }
    public void preOrderTraversal() {
        if (root != null) preOrderTraversal(root);
    }
    public void postOrderTraversal() {
        if (root != null) postOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode node) {
        if (node.prev != null) inOrderTraversal(node.prev);
        System.out.printf("Current node value: %d\n", node.value);
        if (node.next != null) inOrderTraversal(node.next);
    }
    private void preOrderTraversal(TreeNode node) {
        System.out.printf("Current node value: %d\n", node.value);
        if (node.prev != null) preOrderTraversal(node.prev);
        if (node.next != null) preOrderTraversal(node.next);
    }
    private void postOrderTraversal(TreeNode node) {
        if (node.prev != null) postOrderTraversal(node.prev);
        if (node.next != null) postOrderTraversal(node.next);
        System.out.printf("Current node value: %d\n", node.value);
    }
}
