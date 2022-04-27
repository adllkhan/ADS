package com.company;

import java.rmi.dgc.Lease;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private static class MyNode<T> {
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList(T data) {
        MyNode mynode = new MyNode(data);
    }

    public MyLinkedList() {}

    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<T>(item);
        newNode.next = head;
        head = newNode;
        length++;
        if (tail == null)
            tail = head;
    }

    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<T>(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {
        MyNode<T> current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        MyNode<T> temp = current.next;
        current.next = new MyNode<T>(item);
        (current.next).next = temp;
        length++;
    }

    public T removeFirst() {
        if (length == 0) {
            return null;
        }
        else {
            MyNode<T> temp = head;
            head = head.next;
            length--;
            if (head == null) {
                tail = null;
            }
            return temp.data;
        }
    }

    public T removeLast() {
        if (length == 0) {
            return null;
        } else if (length == 1) {
            MyNode<T> temp = head;
            head = tail = null;
            length = 0;
            return temp.data;
        } else {
            MyNode<T> current = head;
            for (int i = 0; i < length - 2; i++) {
                current = current.next;
            }
            MyNode<T> temp = tail;
            tail = current;
            tail.next = null;
            length--;
            return temp.data;
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == length- 1) {
            return removeLast();
        } else {
            MyNode<T> previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            MyNode<T> current = previous.next;
            previous.next = current.next;
            length--;
            return current.data;
        }
    }
    @Override
    public void clear() {
        length = 0;
        head = tail = null;
    }

    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");
        MyNode<T> temp = head;
        while (index != 0) {
            temp = temp.next;
            index--;
        }
        return temp.data;
    }

    @Override
    public int indexOf(Object o) {
        MyNode<T> current = head;
        for (int i = 0; i < length; i++) {
            if (current.data.equals(o))
                return i;
            current = current.next;
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        MyNode<T> current = head;
        int lastIndex = -1;
        for (int i = 0; i < length; i++) {
            if (current.data.equals(o))
                lastIndex = i;
            current = current.next;
        }
        return lastIndex;
    }

    @Override
    public void sort() {
        MyNode<T> current = head, index = null;
        T temp;
        if (head == null) {
            return;
        } else {
            while (current != null) {
                index = current.next;
                while (index != null) {
                    if (current.data.equals(index.data)) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        MyNode<T> current = head;
        if (current.data.equals(o))
            return true;
        current = current.next;
        return false;
    }
}
