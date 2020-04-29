package com.codingquestions.app.LinkedList;

import com.codingquestions.app.util.ListNode;

// Problem:
/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Example
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * Output: 7 -> 0 -> 8
 */

// Solution:
// TIME: O(1)
// SPACE: O(n)
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        int val = 0;

        while (a != null || b != null || val != 0) {
            if (a != null) {
                val += a.value;
                a = a.next;
            }

            if (b != null) {
                val += b.value;
                b = b.next;
            }

            cur.next = new ListNode(val % 10);
            val = val / 10;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
