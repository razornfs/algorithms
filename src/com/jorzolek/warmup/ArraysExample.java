package com.jorzolek.warmup;

public class ArraysExample {
    public static void printDuplicates(int[] arr1, int[] arr2) {
        for (int i : arr1) {
            for (int j : arr2) {
                if (i == j) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    public static boolean isPalindrome(char[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
