package com.codingquestions.app.LinkedList;

import com.codingquestions.app.util.ListNode;

// Problem:
/** */

// Solution:
// TIME: O(n)
// SPACE: O(1)
public class PartitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        // since I don’t know whether we will need a new head,
        // I want to use a dummyHead

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHeadSmaller = new ListNode(0);
        ListNode dummyHeadBigger = new ListNode(0);

        ListNode dummyHeadSmallerPointer = dummyHeadSmaller;
        ListNode dummyHeadBiggerPointer = dummyHeadBigger;

        while (head != null) {
            if (head.value < target) {
                dummyHeadSmallerPointer.next = head;
                dummyHeadSmallerPointer = dummyHeadSmallerPointer.next;
            } else {
                dummyHeadBiggerPointer.next = head;
                dummyHeadBiggerPointer = dummyHeadBiggerPointer.next;
            }
            head = head.next;
        }
        dummyHeadSmallerPointer.next = dummyHeadBigger.next;
        dummyHeadBiggerPointer.next = null;
        return dummyHeadSmaller.next;
    }

    public static void main(String[] args) {
        PartitionLinkedList instance = new PartitionLinkedList();
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);

        System.out.println(head);
        System.out.println(instance.partition(head, 1));
    }
}
