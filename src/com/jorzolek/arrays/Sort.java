package com.jorzolek.arrays;

import java.util.Arrays;

public class Sort {

    private int count = 0;

    public void bubbleSort(int[] arr) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    sorted = false;
                }
            }
        }
    }

    public void quickSort(int[] arr, int begin, int end) {
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

    public int getCount() {
        return count;
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                count++;
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
                i++;
            }
        }

        int swap = arr[i];
        arr[i] = arr[end];
        arr[end] = swap;

        return i;
    }
}
