package com.study.data;

/**
 *
 */
public class Tree<V> {

    class Node {

        Node left;

        Node right;

        V v;

        public Node (V v) {
            this(null, null, v);
        }

        public Node (Node left, Node right, V v) {
            this.left = left;
            this.right = right;
            v = v;
        }

    }

    public Tree () {
    }

}
