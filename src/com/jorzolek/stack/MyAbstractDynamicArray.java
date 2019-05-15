package com.jorzolek.stack;

import java.util.Arrays;

public abstract class MyAbstractDynamicArray<T> {
    protected T[] dynamicArray;

    protected int index;

    public MyAbstractDynamicArray() {
        this.dynamicArray = ((T[]) new Object[2]);
    }

    private void ensureCapacity() {
        if (index == dynamicArray.length) {
            dynamicArray = Arrays.copyOf(dynamicArray, dynamicArray.length * 2);
        }
    }

    protected void add(T element) {
        ensureCapacity();
        dynamicArray[index] = element;
        index++;
    }

    public int size() {
        return index;
    }
}
