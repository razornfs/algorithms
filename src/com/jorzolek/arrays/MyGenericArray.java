package com.jorzolek.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Stream;

public class MyGenericArray<T> implements Iterable<T> {
    private Object[] arr;
    private int size;

    public MyGenericArray(T[] arr) {
        int newLength = arr.length;
        this.arr = new Object[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, newLength);
        size = arr.length;
    }

    public MyGenericArray() {
        arr = new Object[10];
    }

    public int size() {
        return size;
    }

    public int find(T elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public T pick(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(
                    String.format("Podales zly indeks, musi byc w przedziale [0, %d]", arr.length - 1));
        }
        return (T) arr[index];
    }

    public void push(T toPush) {
        size++;
        grow();
        arr[size - 1] = toPush;
    }

    private void grow() {
        if (size > arr.length) {
            Object[] temp = new Object[arr.length * 2 + 1];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            arr = temp;
        }
    }

    private void shrink() {
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException("Nie ma elementow");
        }
        if (size * 4 < arr.length) {
            Object[] temp = new Object[arr.length / 2];
            System.arraycopy(arr, 0, temp, 0, size);
            arr = temp;
        }
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        size--;
        shrink();
        arr[size + 1] = null;
        return (T) arr[size];
    }

    public void unshift(T element) {
        size++;
        grow();
        System.arraycopy(arr, 0, arr, 1, size - 1);
        arr[0] = element;
    }

    @SuppressWarnings("unchecked")
    public T shift() {
        size--;
        shrink();
        T ret = (T) arr[0];
        System.arraycopy(arr, 1, arr, 0, size);
        arr[size + 1] = null;
        return ret;
    }

    public void insert(int index, T element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Próba wstawienia poza rozmiar tablicy");
        }
        size++;
        grow();
        System.arraycopy(arr, index, arr, index + 1, size - 1 - index);
        arr[index] = element;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Próba usunięcia elementu poza tablicą");
        }
        size--;
        shrink();
        T ret = (T) arr[index];
        System.arraycopy(arr, index + 1, arr, index, size - index);
        return ret;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void sort() {
        Arrays.sort(arr, 0, size);
    }

    @SuppressWarnings("unchecked")
    public void sort(Comparator<T> comparator) {
        Arrays.sort((T[]) arr, 0, size, comparator);
    }

    @SuppressWarnings("unchecked")
    public MyGenericArray<T> reverse() {
        Object[] reversed = new Object[size];
        System.arraycopy(arr, 0, reversed, 0, size);
        int i = 0;
        int j = size - 1;
        while (i < j) {
            Object temp = reversed[i];
            reversed[i] = reversed[j];
            reversed[j] = temp;
            i++;
            j--;
        }
        return new MyGenericArray<>((T[]) reversed);
    }

    @SuppressWarnings("unchecked")
    public Stream<T> stream() {
        return Arrays.stream((T[]) Arrays.copyOf(arr, size));
    }

    public void print() {
        System.out.println(Arrays.toString(Arrays.copyOf(arr, size)));
        System.out.println("Liczba elementow: " + size);
        System.out.println("Faktyczny rozmiar tablicy: " + arr.length);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyGenericArrayIterator();
    }

    private class MyGenericArrayIterator implements Iterator<T> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            return (T) arr[currentIndex++];
        }

        @Override
        public void remove() {
            MyGenericArray.this.remove(currentIndex);
        }
    }
}
