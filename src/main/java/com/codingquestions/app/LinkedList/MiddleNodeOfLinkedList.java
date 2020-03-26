package com.codingquestions.app.LinkedList;

import com.codingquestions.app.utils.ListNode;

// Problem:
/**
 * Find the middle node of a given linked list.
 * 
 * Examples
 * 
 * L = null, return null L = 1 -> null, return 1 L = 1 -> 2 -> null, return 1 L
 * = 1 -> 2 -> 3 -> null, return 2 L = 1 -> 2 -> 3 -> 4 -> null, return 2
 */

// Solution:
// TIME: O(n)
// SPACE: O(1)
public class MiddleNodeOfLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

        }
        return slowPointer;
    }

}
