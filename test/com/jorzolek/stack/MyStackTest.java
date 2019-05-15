package com.jorzolek.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {

    private MyStack<Integer> myStack;

    @Before
    public void before() {
        myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
    }

    @Test
    public void testPush() {
        //given
        int el1 = 5;
        int el2 = 6;
        //when
        myStack.push(el1);
        myStack.push(el2);
        //then
        Assert.assertTrue(myStack.contains(el1));
        Assert.assertTrue(myStack.contains(el2));
    }

    @Test
    public void testPop() {
        int el1 = 5;
        myStack.push(el1);
        Assert.assertEquals(el1, (int) myStack.pop());
        Assert.assertFalse(myStack.contains(el1));
    }

    @Test(expected = IllegalStateException.class)
    public void testPopEmpty() {
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop(); //wyjątek
    }
    //contains, pick
}
