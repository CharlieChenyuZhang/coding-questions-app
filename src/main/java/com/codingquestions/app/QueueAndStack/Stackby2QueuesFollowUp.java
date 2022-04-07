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

// followup with additional assumptions:
// queue has only offer() and poll() operations;
// we cannot call isEmpty(), peek(), size() etc.
public class Stackby2QueuesFollowUp {

    /** Initialize your data structure here. */
    Queue<Integer> q1;
    Queue<Integer> q2; // buffer

    public Stackby2QueuesFollowUp() {
        q1 = new ArrayDeque<Integer>();
        q2 = new ArrayDeque<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
       Integer prev = q1.poll();
       Integer cur = q1.poll();
       while (cur != null) {
           q2.offer(prev);
           prev = cur;
           cur = q1.poll();
       }
       Queue<Integer> tmp = q1;
       q1 = q2;
       q2 = tmp;
       return prev;
    }

    /** Get the top element. */
    public Integer top() {
        Integer ret = pop();
        if (ret != null) {
            q1.offer(ret);
        }
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return top() == null;
    }
}
