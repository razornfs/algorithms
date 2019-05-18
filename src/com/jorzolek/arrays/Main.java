package com.jorzolek.arrays;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = Sort.randomArray(100);
        Sort.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}