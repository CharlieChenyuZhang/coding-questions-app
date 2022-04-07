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
public class StackWithMin1 {
    Deque<Integer> stack;
    int globalMin;

    public StackWithMin1() {
        stack = new ArrayDeque<>();
        globalMin = Integer.MAX_VALUE;
    }

    // TIME: O(1)
    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }

        int topValue = stack.pollFirst();
        if (topValue >= globalMin) {
            return topValue;
        } else { // when topValue < globalMin
            int value = globalMin;
            globalMin = 2 * globalMin - topValue;
            return value;
        }
    }

    // TIME: O(1)
    public void push(int element) {
        if (stack.isEmpty()) {
            stack.offerFirst(element);
            globalMin = element;
            return;
        }

        if (element >= globalMin) {
            stack.offerFirst(element);
        } else {
            stack.offerFirst(2 * element - globalMin); // when element < globalMin
            globalMin = element;
        }
    }

    // TIME: O(1)
    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        int topValue = stack.peekFirst();
        if (topValue >= globalMin) {
            return topValue;
        } else {
            return globalMin;
        }
    }

    // TIME: O(1)
    public int min() {
        if (stack.isEmpty()) {
            return -1;
        }
        return globalMin;
    }
}