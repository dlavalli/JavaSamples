package com.lavalliere.daniel.aps;
import java.util.Comparator;

public class TreeOpsGenerics<T> {

        private TreeNode<T>  root;

        //public class TreeNode<T> implements Comparator<T> {
        // public class TreeNode<T extends Comparable<T>> {
        public class TreeNode<T> {
            public T value;
            private TreeNode<T> prev;
            private TreeNode<T> next;
            private int occurences;

            public TreeNode(T value) {
                this.value = value;
                this.occurences = 1;
            }
            public TreeNode(T value, TreeNode<T> prev, TreeNode<T> next) {
                this.value = value;
                this.prev = prev;
                this.next = next;
                this.occurences = 1;
            }

            //public int compareTo(TreeNode<T> node) {
            //    return this.value.compareTo(node.value);
            //}
        }

        public TreeOpsGenerics() {
        }


        public void insertValue(TreeNode<T> parent, TreeNode<T> node) {
            /*
            if (parent.compareTo())
                if (parent.value == node.value) {
                    parent.occurences++;
                } else if (node.value < parent.value) {

                } else if (node.value > parent.value) {

                }

             */
        }

        public void insertValue(T value) {
            /*
            TreeNode<T> node  = new TreeNode<T>(value);
            if (root == null) {
                this.root = node;
            } else {
                insertValue(this.root, node);
            }
             */
        }
}
