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
        for(int i = 0; i < size; i++) {
            if(key == bst.get(i).getKey()) {
                return i;
            }
        }
        return size;
    }

    private void sort() {
        for(int i = 0; i < size-1; i++) {
            for(int j = 0; j < size-i-1; j++) {
                if (hash(bst.get(j).getKey()) > hash(bst.get(j+1).getKey())) {
                    Node helper = bst.get(j);
                    bst.set(j, bst.get(j+1));
                    bst.set(j+1, helper);
                }
            }
        }
    }

    private int searchIndex(K key) {
        int divider = 2;
        int i = (size-1)/divider;
        while(i < size) {
            if(hash(key) > hash(bst.get(i).getKey())) {
                divider *= 2;
                i += (size-1)/divider;
            } else if(hash(key) == hash(bst.get(i).getKey())){
                return i;
            } else {
                divider *= 2;
                i -= (size-1)/divider;
            }
        }
        System.out.println("ERROR in search() or could not find by key.");
        return 0;
    }

    public void put(K key, V value) {
        Node newNode = new Node(key, value);
        bst.add(newNode);
        size++;
        sort();
    }

    public V get(K key) {
        if(hash(key) != size) {
            return bst.get(searchIndex(key)).getValue();
        }
        System.out.println("ERROR in get() or could not find value.");
        return null;
    }

    public void delete(K key) {
        if(hash(key) != size) {
            bst.remove(searchIndex(key));
            return;
        }
        System.out.println("ERROR in delete() or could not find by key.");
    }

//    public Iterable<K> iterator() {}
}
