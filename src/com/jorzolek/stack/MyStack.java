package com.jorzolek.stack;

public class MyStack<T> extends MyAbstractDynamicArray<T> {

    public MyStack() {
        super();
    }

    public void push(T element) {
        add(element);
    }

    public T pop() {
        if (index == 0) {
            throw new IllegalStateException("Stos jest pusty");
        }
        return dynamicArray[--index];
    }

    public T peek() {
        if (index == 0) {
            throw new IllegalStateException("Stos jest pusty");
        }
        return dynamicArray[index - 1];
    }

    public void print() {
        if (index == 0) {
            System.out.println("Stos jest pusty");
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            System.out.print(dynamicArray[i] + ", ");
        }
        System.out.println(dynamicArray[index - 1]);
    }

    public boolean contains(T elem) {
        for (int i = 0; i < index; i++) {
            if (dynamicArray[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }
}
