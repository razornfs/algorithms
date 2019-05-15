package com.jorzolek.binarysearchtree;

public class MyBinarySearchTree<T extends Comparable<T>> {
    private MyNode<T> root;

    public void add(T value) {
        if (value == null) {
            return;
        }
        if (root == null) {
            root = new MyNode<>(value);
        } else {
            add(value, root);
        }
    }

    private void add(T value, MyNode<T> node) {
        if (value.compareTo(node.getValue()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new MyNode<>(value));
            } else {
                add(value, node.getLeft());
            }
        } else if (value.compareTo(node.getValue()) > 0) {
            if (node.getRight() == null) {
                node.setRight(new MyNode<>(value));
            } else {
                add(value, node.getRight());
            }
        } else {
            System.out.println("Duplikat: " + value);
        }
    }

    public boolean contains(T value) {
        return contains(value, root);
    }

    private boolean contains(T value, MyNode<T> node) {
        if (node == null) {
            return false;
        }
        if (value.compareTo(node.getValue()) < 0) {
            return contains(value, node.getLeft());
        }
        if (value.compareTo(node.getValue()) > 0) {
            return contains(value, node.getRight());
        }
        return true;
    }

    public T min() {
        if (root == null) {
            return null;
        }
        MyNode<T> min = root;
        while (min.getLeft() != null) {
            min = min.getLeft();
        }
        return min.getValue();
    }

    public T max() {
        if (root == null) {
            return null;
        }
        MyNode<T> max = root;
        while (max.getRight() != null) {
            max = max.getRight();
        }
        return max.getValue();
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(MyNode<T> node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(MyNode<T> node) {
        if (node != null) {
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(MyNode<T> node) {
        if (node != null) {
            inorder(node.getLeft());
            System.out.print(node.getValue() + " ");
            inorder(node.getRight());
        }
    }
}
