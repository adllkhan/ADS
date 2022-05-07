package com.company;

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

    private HashNode<K, V>[] chainArray;
    private int defaultSize = 11;
    private int size;

    public MyHash() {
        this.chainArray = new HashNode[defaultSize];
    }
    public MyHash(int M){
        size = M;
        this.chainArray = new HashNode[size];
    }

    public int size(){
        return size;
    }

    private int hash(K key) {
        return (int)key % size;
    }

    public void put(K key, V value) {
        HashNode<K, V> newNode = new HashNode<>(key, value);
        chainArray[hash(key)] = newNode;
        size++;
    }

    public V get(K key) {
        return chainArray[(int)key].getValue();
    }

    public V remove(K key) {
        V helper = chainArray[(int)key].getValue();
        HashNode<K, V>[] helperArray = new HashNode[size];
        int j = 0;
        for(int i = 0; i < size; i++) {
            if((int)key == i){
                continue;
            } else {
                helperArray[j++] = chainArray[i];
            }
        }
        chainArray = helperArray;
        size--;
        return helper;
    }

    public boolean contains(V value) {
        for (int i = 0; i < size; i++) {
            if (value == chainArray[i].getValue()) {
                return true;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < size; i++) {
            if (value == chainArray[i].getValue()) {
                return chainArray[i].getKey();
            }
        }
        System.out.println("ERROR");
        return null;
    }
}
