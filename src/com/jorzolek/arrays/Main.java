package com.jorzolek.arrays;

public class Main {

    public static void main(String[] args) {
        MyArray myArray = new MyArray(new int[]{});
        myArray.print();
        System.out.println(myArray.length());

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

        myArray.pop();
        myArray.print();

        myArray.pop();
        myArray.print();

        myArray.pop();
        myArray.print();

        myArray.pop();
        myArray.print();

        myArray.pop();
        myArray.print();

        myArray.pop();
        myArray.print();
    }
}
