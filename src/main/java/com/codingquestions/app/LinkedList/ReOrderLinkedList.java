package com.codingquestions.app.LinkedList;

import com.codingquestions.app.utils.ListNode;

// Problem:
/**
 * Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null
 * to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null
 * 
 * Examples
 * 
 * L = null, is reordered to null L = 1 -> null, is reordered to 1 -> null L = 1
 * -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null L = 1 -> 2
 * -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
 */

// Solution:
// TIME: O(n)
// SPACE: O(1)
public class ReOrderLinkedList {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode midNode = findMidNode(head);
        ListNode secondHalf = midNode.next;
        midNode.next = null;
        ListNode firstHalf = head;

        ListNode reversedSecondHalf = reverse(secondHalf);
        return merge(firstHalf, reversedSecondHalf);
    }

    // TIME: O(n)
    // SPACE: O(1)
    private ListNode findMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    // TIME: O(n)
    // SPACE: O(1)
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // curr == null
        return prev;
    }

    // TIME: O(n)
    // SPACE: O(1)
    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummyHead = new ListNode(0);

        ListNode pointer1 = one;
        ListNode pointer2 = two;

        ListNode curr = dummyHead;
        while (pointer1 != null && pointer2 != null) {
            curr.next = pointer1;
            pointer1 = pointer1.next;
            curr = curr.next;
            curr.next = pointer2;
            pointer2 = pointer2.next;
            curr = curr.next;
        }
        // post-processing
        if (pointer1 != null) {
            curr.next = pointer1;
        } else {
            curr.next = pointer2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ReOrderLinkedList instance = new ReOrderLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(head);
        System.out.println(instance.reorder(head));
    }

}
