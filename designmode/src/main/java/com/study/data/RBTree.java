package com.study.data;

/**
 *
 */
public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;

    private static final boolean BLACK = false;

    private class Node {

        public K key;

        public V value;

        public Node left;

        public Node right;

        public boolean clour;

        public Node (K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            clour = RED;
        }

    }

}
