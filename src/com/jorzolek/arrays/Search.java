package com.jorzolek.arrays;

public class Search {
    public int linearSearch(int element, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int element, int[] arr) {
        //tablica musi być posortowana
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] > element) {
                high = mid - 1;
            } else if (arr[mid] < element) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
