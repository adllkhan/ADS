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
        chainArray[hash(key)] = key;
    }

    public V get(K key) {}

    public V remove(K key) {}

    public boolean contains(V value) {}

    public K getKey(V value) {}
}
