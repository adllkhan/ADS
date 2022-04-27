package com.company;

class MyHeap <T extends Comparable<T>> {
    MyArrayList<T> heap = new MyArrayList<> ();

    public void heapify(int i) {
        while (i < size()) {
            T max = heap.get(i);
            int max_i = i;
            if (i*2<size() && max.compareTo(heap.get(i*2))<0) {
                max = heap.get(i*2);
                max_i = i*2;
            }
            if (i*2+1<size() && max.compareTo(heap.get(i*2+1))<0) {
                max = heap.get(i*2+1);
                max_i = i*2+1;
            }
            if (max_i != i) {

                T temp = heap.get(i);
                heap.add(heap.get(max_i), i);
                heap.add(temp, max_i);
                i = max_i;
            } else {
                break;
            }
        }
    }

    public void add(T data) {
        heap.add(data);
        heapify((int)data);
    }

    public T remove(int i) {
        T item = heap.get(i);
        T temp = heap.get(i);
        heap.add(heap.get(size()-1), i);
        heap.add(temp, i);
        heap.remove(size()-1);
        heapify(i);
        return item;
    }

    public void removeRoot(int index) {
        heap.remove(index/2);
    }

    public int size() {
        return heap.size();
    }
}
