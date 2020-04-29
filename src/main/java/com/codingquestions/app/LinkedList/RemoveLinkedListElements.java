package com.codingquestions.app.LinkedList;

import com.codingquestions.app.util.ListNode;

// Problem:
/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return: 1 --> 2
 * --> 3 --> 4 --> 5
 */

// Solution:
// TIME: O(n)
// SPACE: O(1)
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        while (head != null) {
            if (head.value != val) {
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }
        // post-processing, disconnect the last node
        curr.next = null;
        return dummyHead.next;
    }

}
