package com.jorzolek.binarysearchtree;

public class Main {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>();
        tree.add(50);
        tree.add(25);
        tree.add(75000);
        tree.add(12);
        tree.add(37);
        tree.add(62);
        tree.add(87);
        tree.add(6);
        tree.add(18);
        tree.add(31);
        tree.add(43);
        tree.add(56);
        tree.add(68);
        tree.add(81);
        tree.add(93);
        tree.add(0);
//        tree.preorder();
//        tree.postorder();
        tree.prettyPrint();
//        tree.delete();
    }
}
