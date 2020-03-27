package com.codingquestions.app.LinkedList;

import com.codingquestions.app.utils.ListNode;

// Problem:
/**
 * Given a linked list, check whether it is a palindrome.
 * 
 * Examples:
 * 
 * Input: 1 -> 2 -> 3 -> 2 -> 1 -> null
 * 
 * output: true.
 * 
 * Input: 1 -> 2 -> 3 -> null
 * 
 * output: false.
 * 
 * Requirements:
 * 
 * Space complexity must be O(1)
 */

// Solution:
// TIME: O(n)
// SPACE: O(1)
public class CheckIfLinkedListIsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode mid = findMid(head);
        ListNode right = reverse(mid.next);
        mid.next = null;
        ListNode left = head;

        while (right != null && left != null) {
            if (right.value != left.value) {
                return false;
            }

            right = right.next;
            left = left.next;
        }

        return true;
    }

    // TIME: O(n)
    // SPACE: O(1)
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer.next != null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }

    // time O(n)
    // space O(1)
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;

            // move the pointer to the next one
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        curr.next = new ListNode(3);
        curr = curr.next;
        curr.next = new ListNode(3);
        curr = curr.next;
        curr.next = new ListNode(4);
        curr = curr.next;
        curr.next = new ListNode(3);
        curr = curr.next;
        curr.next = new ListNode(3);
        curr = curr.next;
        curr.next = new ListNode(1);

        System.out.println(head);
        CheckIfLinkedListIsPalindrome instance = new CheckIfLinkedListIsPalindrome();
        System.out.println(instance.isPalindrome(head));
    }
}
