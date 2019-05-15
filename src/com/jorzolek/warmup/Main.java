package com.jorzolek.warmup;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 2};
        int[] arr2 = {2, 3, 4, 2, 1, 1};
        ArraysExample.printDuplicates(arr1, arr2);

        char[] str1 = {'a', 'b', 'b', 'a'};
        System.out.println(ArraysExample.isPalindrome(str1));
    }
}
