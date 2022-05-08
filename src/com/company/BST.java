package com.company;

public class BST<K extends Comparable<K>, V>{
    private Node root;
    private int size = 0;

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private int hash(K key) {
        for(int i = 0; i < size/2; i++) {
            if(key == ) {
                return i;
            }
        }
        return size;
    }

    public void put(K key, V value) {
        Node newNode = new Node(key, value);
        if(size == 0) {
            root = newNode;
            root.setLeft(null);
            root.setRight(null);
        } else if(size == 1) {
            if ((int)newNode.getKey() > (int)root.getKey()) {
                root.setRight(newNode);
            } else {
                root.setLeft(newNode);
            }
        } else {} IIIDDDDDDKKKK omg
    }

    public V get(K key) {}

    public void delete(K key) {}

    public  Iterable<K> iterator() {}
}
