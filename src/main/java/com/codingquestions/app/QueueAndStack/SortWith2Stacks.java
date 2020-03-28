package com.codingquestions.app.QueueAndStack;

import java.util.LinkedList;

// Problem:
/**
 * Given an array that is initially stored in one stack, sort it with one
 * additional stacks (total 2 stacks).
 * 
 * After sorting the original stack should contain the sorted integers and from
 * top to bottom the integers are sorted in ascending order.
 * 
 * Assumptions:
 * 
 * The given stack is not null. There can be duplicated numbers in the give
 * stack. Requirements:
 * 
 * No additional memory, time complexity = O(n ^ 2).
 */

// Solution:
// TIME: O(n^2)
// SPACE: O(1)
public class SortWith2Stacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        if (s1 == null || s1.size() == 0) {
            return;
        }

        while (!s1.isEmpty()) {
            // step 1: push all elements from stack 1 to stack2
            int globalMin = Integer.MAX_VALUE;
            int count = 0;
            while (!s1.isEmpty()) {
                int ele = s1.pollFirst();
                if (ele < globalMin) {
                    globalMin = ele;
                    count = 1;
                } else if (ele == globalMin) {
                    count++;
                }
                s2.offerFirst(ele);
            }

            // step2: push all elements from stack 2 to stack1
            // skip the value when equal to globalMin
            while (!s2.isEmpty() && s2.peekFirst() >= globalMin) {
                int ele = s2.pollFirst();
                if (ele > globalMin) {
                    s1.offerFirst(ele);
                }
            }

            // step3: push the globalMin to stack 2 count number of times
            while (count > 0) {
                s2.offerFirst(globalMin);
                count--;
            }

            // check whether s1 is empty or not, if not, keep going
        }
        // last step: push elements from s2 to s1
        while (!s2.isEmpty()) {
            s1.offerFirst(s2.pollFirst());
        }
    }

}
