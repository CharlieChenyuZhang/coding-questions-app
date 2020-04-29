package com.codingquestions.app.util;

public class Stack {
    // insert from head
    // remove from head
    // Takeaway: because for singly linked list,
    // it’s so much easier to work with head
    ListNode head;

    public Stack() {
    }

    public Integer pop() {
        if (head == null) {
            return null;
        }

        ListNode tmp = head;
        head = head.next;
        head.next = null; // this is optional but safer. It's a habit for engineers
        return tmp.value;
    }

    public void push(Integer ele) {
        if (head == null) {
            head = new ListNode(ele);
            return;
        }

        ListNode newNode = new ListNode(ele);
        newNode.next = head;
        head = newNode;
    }
}
