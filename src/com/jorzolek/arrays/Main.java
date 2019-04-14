package com.jorzolek.arrays;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
/*        int[] test = new int[100000000];
        for (int i = 0; i < test.length; i++) {
            test[i] = i;
        }
        Search s = new Search();
        long avg = 0;
        long avgB = 0;
        int testAmount = 100;
        for (int i = 0; i < testAmount; i++) {
            int random = (int) (Math.random() * test.length);
            long start = System.nanoTime();
            int index = s.linearSearch(random, test);
            long stop = System.nanoTime();
            avg += stop - start;

            long startB = System.nanoTime();
            int indexB = s.binarySearch(random, test);
            long stopB = System.nanoTime();
            avgB += stopB - startB;
        }
        System.out.println("100 uruchomien, srednia: " + avg / testAmount / 1000);
        System.out.println("100 uruchomien, srednia: " + avgB / testAmount / 1000);

        MyGenericArray<Integer> integers = new MyGenericArray<>();
        for (Integer integer : integers) {

        }*/

        Sort s = new Sort();
        int[] test = new int[80000];
        for (int i = 0; i < test.length; i++) {
            test[i] = (int) (Math.random() * 100);
        }
        s.quickSort(test, 0, test.length - 1);
        int count = s.getCount();
        int log = test.length * log(test.length, 2);
        System.out.println(count / log);

    }

    static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }
}