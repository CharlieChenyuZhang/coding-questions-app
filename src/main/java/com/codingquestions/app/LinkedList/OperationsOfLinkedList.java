package com.codingquestions.app.LinkedList;

// Problem:
/** */

// Solution:
public class OperationsOfLinkedList {
    public class LinkedListNode {
        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public int length(LinkedListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    public LinkedListNode get(LinkedListNode head, int index) {
        while (index > 0 && head != null) {
            head = head.next;
            index--;
        }
        return head;
    }

    public LinkedListNode appendHead(LinkedListNode head, int value) {
        LinkedListNode newHead = new LinkedListNode(value);
        newHead.next = head;
        return newHead;
    };

    public LinkedListNode appendTail(LinkedListNode head, int value) {
        LinkedListNode newTail = new LinkedListNode(value);

        // head == null
        if (head == null) {
            return newTail;
        }

        LinkedListNode curr = head; // we need to use the new pointer to avoid loosing control of head
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newTail;
        return head;
    };

    // return new head;
    public LinkedListNode remove(LinkedListNode head, int value) {
        // head == null
        if (head == null) {
            return null;
        }

        // handle a special case
        if (head.value == value) {
            return head.next;
        }

        // head != null
        LinkedListNode curr = head;
        LinkedListNode prev = null;
        while (curr != null) {
            if (curr.value == value) {
                prev.next = curr.next;
                return head;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

}
