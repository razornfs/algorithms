package com.jorzolek.arrays;

public class Main {

    public static void main(String[] args) {
        MyArray myArray = new MyArray(new int[]{});
        myArray.print();
        System.out.println(myArray.size());

        myArray.push(10);
        myArray.print();

        myArray.push(12);
        myArray.print();

        myArray.push(14);
        myArray.print();

        myArray.shift();
        myArray.print();

        myArray.shift();
        myArray.print();

        myArray.shift();
        myArray.print();

        myArray.unshift(14);
        myArray.print();

        myArray.push(14);
        myArray.print();

        myArray.push(14);
        myArray.print();

        myArray.push(14);
        myArray.print();

        myArray.push(14);
        myArray.print();

        myArray.push(14);
        myArray.print();

        myArray.push(14);
        myArray.print();

        myArray.push(14);
        myArray.print();

        myArray.insert(5, 10);
        myArray.print();
    }
}
