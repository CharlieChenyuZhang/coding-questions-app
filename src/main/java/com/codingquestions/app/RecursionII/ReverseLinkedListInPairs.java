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
    // NOTE: Use an example e.g. N1 -> N2 -> N3 -> N4 -> null to clearly
    // define the the nodes that I will need
    // recursive
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode N1 = head;
        ListNode N2 = head.next;
        ListNode N3 = N2.next;

        ListNode subProblem = reverseInPairs(N3);
        ListNode newHead = N2;
        N2.next = N1;
        N1.next = subProblem;
        return newHead;
    }

    // iterative
    // NOTE: same thing for the iterative solution, use N1, N2 and N3 associate them
    // with the exaple
    public ListNode reverseInPairsIterative(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode N1 = head;
        ListNode newHead = N1.next;
        while (N1 != null && N1.next != null) {
            ListNode N2 = N1.next;
            ListNode N3 = N1.next.next; // make sure N1.next != null (NPE)
            N2.next = N1;
            N1.next = N3.next == null ? N3 : N3.next;
            N1 = N3;
        }
        return newHead;
    }

    // // recursive way
    // public ListNode reverseInPairs(ListNode head) {
    // if (head == null || head.next == null) {
    // return head;
    // }

    // ListNode newHead = head.next;
    // head.next = reverseInPairs(head.next.next);
    // newHead.next = head;
    // return newHead;
    // }

    // // iterative
    // public ListNode reverseInPairsIterative(ListNode head) {
    // ListNode dummyHead = new ListNode(0);
    // dummyHead.next = head;
    // ListNode cur = dummyHead;
    // while (cur.next != null && cur.next.next != null) {
    // ListNode next = cur.next;
    // ListNode nextnextnext = cur.next.next.next;
    // cur.next = cur.next.next;
    // cur.next.next = next;
    // next.next = nextnextnext;

    // cur = cur.next.next;
    // }
    // return dummyHead.next;
    // }

}