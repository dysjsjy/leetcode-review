package com.dysjsjy;

public class lk24_1 {

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

    public ListNode swapPairs(ListNode head) {

        //创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            //定义待交换的两个节点
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            //交换节点
            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
        }

        return dummy.next;
    }

    //错误示范
    public ListNode swapPairs2(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode cur = head;
        ListNode temp = null;

        if (cur.next.next == null) {
            temp = cur.next;
            temp.next = cur;
            cur.next = null;
            head = temp;
        }

        while (cur.next.next != null) {
            temp = cur.next;
            cur.next = cur.next.next;
            temp.next = cur;
        }

        temp = cur.next;
        temp.next = cur;
        cur.next = null;

        return head;
    }
}
