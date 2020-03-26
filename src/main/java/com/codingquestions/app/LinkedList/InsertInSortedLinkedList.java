package com.codingquestions.app.LinkedList;

import com.codingquestions.app.utils.ListNode;

// Problem:
/**
 * Insert a value in a sorted linked list.
 * 
 * Examples
 * 
 * L = null, insert 1, return 1 -> null L = 1 -> 3 -> 5 -> null, insert 2,
 * return 1 -> 2 -> 3 -> 5 -> null L = 1 -> 3 -> 5 -> null, insert 3, return 1
 * -> 3 -> 3 -> 5 -> null L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 ->
 * null
 */

// Solution:
// TIME: O(n)
// SPACE: O(1)
public class InsertInSortedLinkedList {
    // Solution 1: without dummyNode
    public ListNode insert(ListNode head, int value) {
        // handle the case that I need to have a new head
        ListNode newNode = new ListNode(value);
        if (head == null || head.value >= value) {
            newNode.next = head;
            return newNode;
        }

        // we find the position and insert it between prev and prev.next
        ListNode prev = head;
        while (prev != null && prev.next != null) {
            if (prev.value <= value && value <= prev.next.value) {
                newNode.next = prev.next;
                prev.next = newNode;
                return head;
            }
            prev = prev.next;
        }

        // insert to tail
        prev.next = newNode;
        return head;
    }

}
