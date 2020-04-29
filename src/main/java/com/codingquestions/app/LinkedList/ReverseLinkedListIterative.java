package com.codingquestions.app.LinkedList;

import com.codingquestions.app.util.ListNode;

// Problem:
/**
 * Reverse a singly-linked list iteratively.
 * 
 * Examples
 * 
 * L = null, return null L = 1 -> null, return 1 -> null L = 1 -> 2 -> 3 ->
 * null, return 3 -> 2 -> 1 -> null
 */

// Solution:
// TIME: O(n)
// SPACE: O(1)
public class ReverseLinkedListIterative {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            // move to the next pos
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
