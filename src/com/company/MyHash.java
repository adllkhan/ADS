package com.company;

public class MyHash <T extends Comparable<T>> {
    int size = 0;
    class DataItem implements Comparable<DataItem> {
        private T data;
        private int key;

        public DataItem (T data, int key) {
            this.data = data;
            this.key = key;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        @Override
        public int compareTo(DataItem o) {
            return 0;
        }
    }

    public int hashCode(int key){
        return key % size;
    }

    MyArrayList<DataItem> hash = new MyArrayList<>();

    public DataItem get(int key) {
        int index = hashCode(key);
        while(hash.get(index) != null) {
            if(hash.get(index).getKey() == key) {
                return hash.get(index);
            }
            index++;
            index = index % size;
        }
        return null;
    }
}
