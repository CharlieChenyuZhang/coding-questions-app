package com.codingquestions.app.QueueAndStack;

import java.util.Deque;
import java.util.Queue;
import java.util.ArrayDeque;

// Problem:
/**
 * Implement a stack containing integers using queue(s). The stack should
 * provide push(x), pop(), top() and isEmpty() operations.
 * 
 * In java: if the stack is empty, then top() and pop() will return null.
 * 
 * In Python: if the stack is empty, then top() and pop() will return None.
 * 
 * In C++: if the stack is empty, then top() and pop() will return nullptr.
 */

// Solution:
// TIME:
// SPACE:
public class Stackby2Queues {

    /** Initialize your data structure here. */
    Queue<Integer> queue1;
    Queue<Integer> queue2; // buffer

    public Stackby2Queues() {
        queue1 = new ArrayDeque<Integer>();
        queue2 = new ArrayDeque<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        // if only have one elements
        if (queue1.isEmpty()) {
            return null;
        }

        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        int value = queue1.poll();

        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }

        return value;
    }

    /** Get the top element. */
    public Integer top() {
        // if only have one elements
        if (queue1.isEmpty()) {
            return null;
        }

        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        int value = queue1.peek();
        queue2.offer(queue1.poll());

        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }

        return value;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return queue1.size() == 0;
    }
}
