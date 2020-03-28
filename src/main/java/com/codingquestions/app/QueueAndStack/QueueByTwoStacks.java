package com.codingquestions.app.QueueAndStack;

import java.util.Deque;
import java.util.ArrayDeque;

// Problem:
/**
 * Java: Implement a queue by using two stacks. The queue should provide size(),
 * isEmpty(), offer(), poll() and peek() operations. When the queue is empty,
 * poll() and peek() should return null.
 * 
 * C++: Implement a queue by using two stacks. The queue should provide size(),
 * isEmpty(), push(), front() and pop() operations. When the queue is empty,
 * front() should return -1.
 * 
 * Assumptions
 * 
 * The elements in the queue are all Integers. size() should return the number
 * of elements buffered in the queue. isEmpty() should return true if there is
 * no element buffered in the queue, false otherwise.
 */

// Solution:
// TIME:
// SPACE:
public class QueueByTwoStacks {
    private Deque<Integer> s1;
    private Deque<Integer> s2;
    private int size;

    public QueueByTwoStacks() {
        // s1 is used for offer only
        s1 = new ArrayDeque<>();
        // s2 is used for poll only
        s2 = new ArrayDeque<>();
        size = 0;
    }

    // AMORTIZED TIME: O((2n + 1 + (n - 1))/n) = O(3) = O(1)
    public Integer poll() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                return null;
            } else {
                while (!s1.isEmpty()) {
                    s2.offerFirst(s1.pollFirst());
                }
            }
        }
        size--;
        return s2.pollFirst();
    }

    // TIME: O(1)
    public void offer(int element) {
        s1.offerFirst(element);
        size++;
    }

    // TIME: O(1) because peekFirst and peekLast are all O(1) because arrayDeque
    // stores the head and tail index
    public Integer peek() {
        return !s2.isEmpty() ? s2.peekFirst() : s1.peekLast();
    }

    // TIME: O(1)
    public int size() {
        return size;
    }

    // TIME: O(1)
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

}
