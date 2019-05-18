package com.jorzolek.arrays;

import java.util.Arrays;
import java.util.Random;

public class Sort {


    public static void bubbleSort(int[] arr) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i, i - 1);
                    sorted = false;
                }
            }
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
/*
            System.out.println(
                    String.format("Sortuję od %d do %d ze środkiem o indeksie %d i wartości %d na tablicy %s", begin,
                                  end,
                                  partitionIndex, arr[partitionIndex],
                                  Arrays.toString(arr)));*/
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, end, i);

        return i;
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            swap(arr, i, minIndex(arr, i, arr.length));
        }
    }

    private static int minIndex(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        int minIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertIndex = insertIndex(arr, i);
            insert(arr, insertIndex, i);
        }
    }

    private static int insertIndex(int[] arr, int i) {
        int index = Arrays.binarySearch(arr, 0, i, arr[i]);
        return index < 0 ? -(index + 1) : index;
    }

    private static void insert(int[] arr, int insertIndex, int elementIndex) {
        int temp = arr[elementIndex];
        for (int i = elementIndex; i > insertIndex; i--) {
            arr[i] = arr[i - 1];
        }
        arr[insertIndex] = temp;
    }

    public static int[] randomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(size);
        }
        return arr;
    }
}
