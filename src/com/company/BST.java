package com.company;

import java.util.ArrayList;

public class BST<K extends Comparable<K>, V>{
    private int size = 0;
    ArrayList<Node> bst;

    private class Node {
        private K key;
        private V value;

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

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public BST(){
        this.bst = new ArrayList<>();
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
            bst.add(newNode);
        } else {
            int i = 2;
            while(i < size) {
                if (hash(key) > size/i) {

                } else {

                }
                i *= 2;
            }
        }
    }

    public V get(K key) {}

    public void delete(K key) {}

    public  Iterable<K> iterator() {}
}
