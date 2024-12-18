package com.dysjsjy;

import java.util.Deque;
import java.util.LinkedList;

public class lk206_1 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Deque<Integer> deque = new LinkedList<>();

        ListNode cur = head;

        while (cur != null) {
            deque.push(cur.val);
            cur = cur.next;
        }

        cur = head;
        while (!deque.isEmpty()) {
            cur.val = deque.pop();
            cur = cur.next;
        }

        return head;
    }
}