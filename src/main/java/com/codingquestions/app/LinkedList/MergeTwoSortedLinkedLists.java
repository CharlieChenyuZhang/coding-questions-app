package com.codingquestions.app.LinkedList;

import com.codingquestions.app.utils.ListNode;

// Problem:
/**
 * Merge two sorted lists into one large sorted list.
 * 
 * Examples
 * 
 * L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4
 * -> 5 -> 6 -> null L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2
 * -> null L1 = null, L2 = null, merge L1 and L2 to null
 */

// Solution:
// TIME: O(M + N)
// SPACE: O(1)
public class MergeTwoSortedLinkedLists {
    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        ListNode pointer1 = one;
        ListNode pointer2 = two;

        while (pointer1 != null && pointer2 != null) {
            if (pointer1.value <= pointer2.value) {
                curr.next = pointer1;
                curr = curr.next;
                pointer1 = pointer1.next;
            } else {
                curr.next = pointer2;
                curr = curr.next;
                pointer2 = pointer2.next;
            }
        }

        if (pointer1 == null) {
            curr.next = pointer2;
        } else {
            curr.next = pointer1;
        }
        return dummyHead.next;
    }

}
