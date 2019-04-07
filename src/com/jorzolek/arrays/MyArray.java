package com.jorzolek.arrays;

import java.util.Arrays;

public class MyArray {
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

    public int length() {
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
        if (index < 0 || index >= arr.length) {
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

    public void unshift(int i) {
        size++;
        ensureCapacity();
        int[] temp = new int[arr.length];
        temp[0] = i;
        for (int j = 1; j < arr.length; j++) {
            temp[j] = arr[j - 1];
        }
        arr = temp;
    }

    public int shift() {
        size--;
        ensureCapacity();
        int ret = arr[0];
        int[] temp = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            temp[i - 1] = arr[i];
        }
        arr = temp;
        return ret;
    }
}
