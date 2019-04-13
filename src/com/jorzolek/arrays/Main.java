package com.jorzolek.arrays;

public class Main {

    public static void main(String[] args) {
/*        MyGenericArray<String> myGenericArray = new MyGenericArray<>(new String[]{"aa", "bb", "cc"});
        myGenericArray.print();*/
        MyArray myArray = new MyArray(new int[]{1, 2, 3, 4});
        myArray.print();
        System.out.println(myArray.shift());
        myArray.print();
        myArray.unshift(1);
        myArray.print();
    }
}