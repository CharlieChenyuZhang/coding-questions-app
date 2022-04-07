package com.codingquestions.app.QueueAndStack;

import java.util.Deque;
import java.util.ArrayDeque;

// Problem:
/**
 * 
 * Enhance the stack implementation to support min() operation. min() should
 * return the current minimum value in the stack. If the stack is empty, min()
 * should return -1.
 * 
 * push(int element) - push the element to top pop() - return the top element
 * and remove it, if the stack is empty, return -1 top() - return the top
 * element without remove it, if the stack is empty, return -1 min() - return
 * the current min value in the stack.
 * 
 */

// Solution:
public class StackWithMin2 {
    Deque<Integer> stack; // stores the original value
    Deque<Integer> minStack; // store the min element so far in stack

    public StackWithMin2() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    // TIME: O(1)
    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }

        minStack.pollFirst();
        return stack.pollFirst();
    }

    // TIME: O(1)
    public void push(int element) {
        if (stack.isEmpty()) {
            stack.offerFirst(element);
            minStack.offerFirst(element);
            return;
        }

        int newMin = element < minStack.peekFirst() ? element : minStack.peekFirst();
        stack.offerFirst(element);
        minStack.offerFirst(newMin);
    }

    // TIME: O(1)
    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peekFirst();
    }

    // TIME: O(1)
    public int min() {
        if (stack.isEmpty()) {
            return -1;
        }
        return minStack.peekFirst();
    }
}