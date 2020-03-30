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
public class Stackby1Queues {

    /** Initialize your data structure here. */
    Queue<Integer> queue;

    public Stackby1Queues() {
        queue = new ArrayDeque<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        // if only have one elements
        if (queue.isEmpty()) {
            return null;
        }

        int size = queue.size();
        while (size-- > 1) {
            queue.offer(queue.poll());
        }

        return queue.poll();
    }

    /** Get the top element. */
    public Integer top() {
        if (queue.isEmpty()) {
            return null;
        }

        int size = queue.size();
        while (size-- > 1) {
            queue.offer(queue.poll());
        }

        int result = queue.peek();
        queue.offer(queue.poll());
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return queue.size() == 0;
    }
}
