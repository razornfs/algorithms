package com.jorzolek.arrays;

public class Main {

    public static void main(String[] args) {
        MyGenericArray<String> myGenericArray = new MyGenericArray<>(new String[]{"aa", "bb", "cc"});
        myGenericArray.print();
    }
}