package com.jorzolek.stack;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> test = new MyStack<>();
        test.push(5);
        test.push(7);
        test.push(8);
        test.print();
    }
}
