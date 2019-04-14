package com.jorzolek.containers;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {

    private class Node {
        T item;
        Node next;
    }

    private Node head;

    public MyLinkedList(T item) {
        this.head = new Node();
        head.item = item;
    }

    public MyLinkedList() {
        this.head = new Node();
    }

    public boolean append(T newItem) {
        Node oldHead = head;
        head = new Node();
        head.item = newItem;
        if (oldHead.item == null) {
            head.next = null;
        } else {
            head.next = oldHead;
        }
        return true;
    }

    public int size() {
        int size = 0;
        if (head.item != null) {
            size++;
        }
        Node counter = head;
        while (counter.next != null) {
            size++;
            counter = counter.next;
        }
        return size;
    }

    public T pop() {
        if (this.head.item == null) {
            throw new NoSuchElementException("Ta lista jest pusta");
        }
        T item = this.head.item;
        if (head.next == null) {
            head = new Node();
        } else {
            head = head.next;
        }
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<T> {

        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null && current.item != null;
        }

        @Override
        public T next() {
            T ret = current.item;
            current = current.next;
            return ret;
        }
    }

}
