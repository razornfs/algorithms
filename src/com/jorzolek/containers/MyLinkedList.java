package com.jorzolek.containers;

public class MyLinkedList<T> {
    private class Node<T> {
        T item;
        Node<T> next;
    }

    private Node<T> head;

    public MyLinkedList(T item) {
        this.head = new Node<>();
        head.item = item;
    }

    public void append(T item) {
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new Node<>();
        tail.next.item = item;
    }
}
