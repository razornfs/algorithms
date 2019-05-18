package com.jorzolek.binarysearchtree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MyBinarySearchTreeTest {

    private MyBinarySearchTree<Integer> tree;

    @Before
    public void before() {
        tree = new MyBinarySearchTree<>();
        tree.add(2);
        tree.add(1);
        tree.add(3);
    }

    @Test
    public void testContains() {
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(3));
    }

    @Test
    public void testAdd() {
        tree.add(4);
        assertTrue(tree.contains(4));
    }

    @Test
    public void testMin() {
        assertEquals(1, (int) tree.min());
        tree.add(0);
        assertEquals(0, (int) tree.min());
    }

    @Test
    public void testMax() {
        assertEquals(3, (int) tree.max());
        tree.add(4);
        assertEquals(4, (int) tree.max());
    }
}
