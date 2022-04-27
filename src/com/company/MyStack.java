package com.company;

public class MyStack<T extends Comparable<T>>  {
    private MyLinkedList<T> stack;
    private int size;

    public MyStack() {
        stack = new MyLinkedList<T>();
        size = 0;
    }

    public boolean empty() {
        return size == 0;
    }

    public void push(T item) {
        size++;
        stack.addFirst(item);
    }

    public T pop() {
        if (!empty())
            size--;
        return stack.removeLast();
    }

    public int size() {
        return size;
    }

    public T peek() {
        return stack.get(1);
    }
}
