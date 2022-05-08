package com.company;

import java.util.ArrayList;

public class MyHash<K, V>{
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private ArrayList<HashNode<K, V>> chainArray;
    private int defaultSize = 11;
    private int size = 0;

    public MyHash() {
        this.chainArray = new ArrayList<>(defaultSize);
    }
    public MyHash(int M){
        size = M;
        this.chainArray = new ArrayList<>(size);
    }

    public int size(){
        return size;
    }

    private int hash(K key) {
        for(int i = 0; i < size; i++) {
            if(key == chainArray.get(i).getKey()) {
                return i;
            }
        }
        return size;
    }

    public void put(K key, V value) {
        HashNode<K, V> newNode = new HashNode<>(key, value);
        chainArray.add(newNode);
        size++;
    }

    public V get(K key) {
        if(hash(key) != size) {
            return chainArray.get(hash(key)).getValue();
        }
        System.out.println("ERROR in get() or could not find value.");
        return null;
    }

    public V remove(K key) {
        if(hash(key) != size) {
            V helper = chainArray.get(hash(key)).getValue();
            chainArray.remove(hash(key));
            size--;
            return helper;
        }
        System.out.println("ERROR in remove() or could not find value.");
        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < size; i++) {
            if (value == chainArray.get(i).getValue()) {
                return true;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < size; i++) {
            if (value == chainArray.get(i).getValue()) {
                return chainArray.get(i).getKey();
            }
        }
        System.out.println("ERROR in getKey() or could not find key.");
        return null;
    }
}
