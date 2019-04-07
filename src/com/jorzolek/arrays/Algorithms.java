package com.jorzolek.arrays;

public class Algorithms {
    public static <E> void printEverySecondElement(E[] arr) {
        for (int i = 0; i < arr.length; i += 2) {
            System.out.println(arr[i]);
        }
    }
}
