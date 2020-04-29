package com.codingquestions.app.LinkedList;

import com.codingquestions.app.util.ListNode;

// Problem:
/**
 * Check if a given linked list has a cycle. Return true if it does, otherwise
 * return false.
 * 
 * Assumption:
 * 
 * You can assume there is no duplicate value appear in the linked list.
 */

// Solution:
// TIME: O(n)
// SPACE: O(1)
public class CheckIfLinkedListHasACycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        // there are two cases
        // the while condition is to handle the case of no cycle
        while (fastPointer.next != null && fastPointer.next.next != null) {
            // NOTE: I must move the pointer first then compare value otherwise it
            // always return true becase we start from the head
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (fastPointer.value == slowPointer.value) {
                return true;
            }
        }
        return false;
    }

}
