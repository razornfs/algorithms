package com.jorzolek.binarysearchtree;

public class Main {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>();
        tree.add(3);
        tree.add(1);
        tree.add(-1);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(5);
        tree.add(7);
        tree.add(8);
//        tree.preorder();
//        tree.postorder();
        tree.inorder();
    }
}
