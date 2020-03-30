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

// Solution: Follow-up question, how to improve the space utilization of
// minStack in StackWithMin2?
public class StackWithMin3 {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    Deque<Integer> sizeOfArrayWhenMinOccured;

    public StackWithMin3() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        sizeOfArrayWhenMinOccured = new ArrayDeque<>();
    }

    // TIME: O(1)
    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }

        // whether we want to pop minStack
        if (sizeOfArrayWhenMinOccured.peekFirst() == stack.size()) {
            minStack.pollFirst();
        }
        return stack.pollFirst();
    }

    // TIME: O(1)
    public void push(int element) {
        if (stack.isEmpty()) {
            stack.offerFirst(element);
            minStack.offerFirst(element);
            sizeOfArrayWhenMinOccured.offerFirst(stack.size());
            return;
        }

        stack.offerFirst(element);
        if (element < minStack.peekFirst()) {
            minStack.offerFirst(element);
            sizeOfArrayWhenMinOccured.offerFirst(stack.size());
        }
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