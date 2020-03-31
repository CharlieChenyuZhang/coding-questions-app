package com.codingquestions.app.QueueAndStack;

import java.util.Deque;
import java.util.ArrayDeque;

// Problem:
/**
 * Java: Implement a deque by using three stacks. The queue should provide
 * size(), isEmpty(), offerFirst(), offerLast(), pollFirst(), pollLast(),
 * peekFirst() and peekLast() operations. When the queue is empty, pollFirst(),
 * pollLast(), peekFirst() and peek() should return null.
 * 
 */

// Solution:
// TIME: Amortized offer takes O (1) time
public class DequeByThreeStacks {

    // NOTE: for stackLeft, stackRight and buffer, I am using
    // set of APIs: offerFirst(ele); pollFirst();
    private Deque<Integer> stackLeft;
    private Deque<Integer> stackRight;
    private Deque<Integer> buffer;

    public DequeByThreeStacks() {
        stackLeft = new ArrayDeque<Integer>();
        stackRight = new ArrayDeque<Integer>();
        buffer = new ArrayDeque<Integer>();
    }

    public void offerFirst(int element) {
        stackLeft.offerFirst(element);
    }

    public void offerLast(int element) {
        stackRight.offerFirst(element);
    }

    public Integer pollFirst() {
        move(stackRight, stackLeft);
        return stackLeft.isEmpty() ? null : stackLeft.pollFirst();
    }

    public Integer pollLast() {
        move(stackLeft, stackRight);
        return stackRight.isEmpty() ? null : stackRight.pollFirst();
    }

    public Integer peekFirst() {
        move(stackRight, stackLeft);
        return stackLeft.isEmpty() ? null : stackLeft.peekFirst();

    }

    public Integer peekLast() {
        move(stackLeft, stackRight);
        return stackRight.isEmpty() ? null : stackRight.peekFirst();
    }

    public int size() {
        return stackLeft.size() + stackRight.size();
    }

    public boolean isEmpty() {
        return stackLeft.isEmpty() && stackRight.isEmpty();
    }

    // when dest is empty, move half of ele from src to dest
    private void move(Deque<Integer> src, Deque<Integer> dest) {
        // move one all elements from src to dest
        if (!dest.isEmpty()) {
            return;
        }

        int half = src.size() / 2;

        for (int i = 0; i < half; i++) {
            buffer.offerFirst(src.pollFirst());
        }

        while (!src.isEmpty()) {
            dest.offerFirst(src.pollFirst());
        }
        while (!buffer.isEmpty()) {
            src.offerFirst(buffer.pollFirst());
        }
    }
}
