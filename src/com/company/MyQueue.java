package com.company;

import java.util.ArrayList;

public class MyQueue <T extends Comparable<T>> {
    MyArrayList<T> queue = new MyArrayList<>();
    int size = 0;

    void push(T data) {
        queue.add(data);
        size++;
    }

    T peek() {
        return queue.get(0);
    }

    T pop() {
        T helper = queue.get(0);
        queue.remove(0);
        return helper;
    }
}
