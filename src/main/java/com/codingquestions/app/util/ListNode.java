
package com.codingquestions.app.util;

public class ListNode {
    public int value; // FIXME: generics
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        next = null;
    }

    @Override
    public String toString() {
        // by ovverridding this method, whenever I use
        // System.out.print(ListNodeInstance), this function is being called
        ListNode curr = this;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.value);
            sb.append(" -> ");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
