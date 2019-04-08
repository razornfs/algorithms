package com.jorzolek.arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyArray implements Iterable<Integer> {
    private int[] arr;
    private int size;

    public MyArray(int[] arr) {
        int newLength = arr.length;
        this.arr = new int[arr.length];
        for (int i = 0; i < newLength; i++) {
            this.arr[i] = arr[i];
        }
        size = arr.length;
    }

    public MyArray() {
        arr = new int[10];
        size = 10;
    }

    public void print() {
        System.out.println(Arrays.toString(Arrays.copyOf(arr, size)));
        System.out.println("Liczba elementow: " + size);
        System.out.println("Faktyczny rozmiar tablicy: " + arr.length);
    }

    public int size() {
        return size;
    }

    public int find(int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    public int pick(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(
                    String.format("Podales zly indeks, musi byc w przedziale [0, %d]", arr.length - 1));
        }
        return arr[index];
    }

    public void push(int toPush) {
        size++;
        ensureCapacity();
        arr[size - 1] = toPush;
    }

    private void ensureCapacity() {
        if (size > arr.length) {
            int[] temp = new int[arr.length * 2 + 1];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        if (size * 4 < arr.length) {
            int[] temp = new int[arr.length / 2];
            for (int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException("Nie ma elementow");
        }
    }

    public int pop() {
        size--;
        ensureCapacity();
        return arr[size];
    }

    public void unshift(int element) {
        size++;
        ensureCapacity();
        for (int i = size - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = element;
    }

    public int shift() {
        size--;
        ensureCapacity();
        int ret = arr[0];
        for (int i = 0; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        return ret;
    }

    public void insert(int index, int number) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Próba wstawienia poza rozmiar tablicy");
        }
        size++;
        ensureCapacity();
        for (int i = size - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = number;
    }

    public int remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Próba usunięcia elementu poza tablicą");
        }
        size--;
        ensureCapacity();
        int ret = arr[index];
        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        return ret;
    }

    public IntStream stream() {
        return Arrays.stream(Arrays.copyOf(arr, size));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayIterator();
    }

    private class MyArrayIterator implements Iterator<Integer> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Integer next() {
            return arr[currentIndex++];
        }

        @Override
        public void remove() {
            MyArray.this.remove(currentIndex);
        }
    }
}
