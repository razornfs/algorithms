package com.jorzolek.arrays;

public class Main {

    public static void main(String[] args) {
        MyGenericArray<String> myArr = new MyGenericArray<>(new String[]{"a", "b", "c", "d", "e"});
        myArr.push("f");
        myArr.print();
        myArr.stream().forEach(System.out::println);
    }
}