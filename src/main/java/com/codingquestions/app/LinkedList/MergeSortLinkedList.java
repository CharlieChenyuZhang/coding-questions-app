package com.codingquestions.app.LinkedList;

import com.codingquestions.app.utils.ListNode;

// Problem:
/**
 * Given a singly-linked list, where each node contains an integer value, sort
 * it in ascending order. The merge sort algorithm should be used to solve this
 * problem.
 * 
 * Examples
 * 
 * null, is sorted to null 1 -> null, is sorted to 1 -> null 1 -> 2 -> 3 ->
 * null, is sorted to 1 -> 2 -> 3 -> null 4 -> 2 -> 6 -> -3 -> 5 -> null, is
 * sorted to -3 -> 2 -> 4 -> 5 -> 6
 * 
 */

// Solution:
// TIME: O(n logn)
// SPACE: O(log n)
public class MergeSortLinkedList {
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = head;
        ListNode sortedLeft = mergeSort(left);
        ListNode sortedRight = mergeSort(right);
        return merge(sortedLeft, sortedRight);
    }

    // TIME: O(n)
    // SPACE: O(1)
    private ListNode findMid(ListNode head) {
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
    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        while (one != null && two != null) {
            if (one.value <= two.value) {
                curr.next = one;
                one = one.next;
            } else {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next;
        }

        // post-processing
        if (one != null) {
            curr.next = one;
        } else {
            curr.next = two;
        }
        return dummyHead.next;
    }

}
