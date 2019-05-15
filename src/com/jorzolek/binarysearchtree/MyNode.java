package com.jorzolek.binarysearchtree;

import java.util.Comparator;

public class MyNode<T extends Comparable<T>> {
    private T value;
    private MyNode<T> left;
    private MyNode<T> right;

    public MyNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public MyNode<T> getLeft() {
        return left;
    }

    public void setLeft(MyNode<T> left) {
        this.left = left;
    }

    public MyNode<T> getRight() {
        return right;
    }

    public void setRight(MyNode<T> right) {
        this.right = right;
    }
}
