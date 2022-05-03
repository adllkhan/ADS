package com.company;

public class MyHash <T extends Comparable<T>> {
    int size = 0;
    class DataItem {
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
    }

    public int hashCode(){
        return 0;
    }


}
