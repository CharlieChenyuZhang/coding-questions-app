package com.codingquestions.app.RecursionII;

import com.codingquestions.app.util.ListNode;

/**
 * Reverse pairs of elements in a singly-linked list.
 * 
 * Examples
 * 
 * L = null, after reverse is null L = 1 -> null, after reverse is 1 -> null L =
 * 1 -> 2 -> null, after reverse is 2 -> 1 -> null L = 1 -> 2 -> 3 -> null,
 * after reverse is 2 -> 1 -> 3 -> null
 * 
 */

// TIME: O(n)
// SPACE: O(n)
public class ReverseLinkedListInPairs {
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = reverseInPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }

    // iterative
    public ListNode reverseInPairsIterative(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next;
            ListNode nextnextnext = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = next;
            next.next = nextnextnext;

            cur = cur.next.next;
        }
        return dummyHead.next;
    }

}