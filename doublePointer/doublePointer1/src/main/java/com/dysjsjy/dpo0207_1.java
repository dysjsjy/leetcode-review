package com.dysjsjy;

import java.util.HashSet;

public class dpo0207_1 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> listNodes = new HashSet<>();

        ListNode pA = headA;

        while (pA != null) {
            listNodes.add(pA);
            pA = pA.next;
        }

        ListNode pB = headB;

        while (pB != null) {
            if (listNodes.contains(pB)) {
                return pB;
            }
            pB = pB.next;
        }

        return null;
    }

    //错误示范
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        //放1位置时，错误在在已经为null和移动后为null都会切换，步数不统一会导致错过交点
        //放2位置时，错误在为null时会多走
        //每次循环中都只能进行一次操作

        while (pA != pB) {

            //1位置

            if (pA == null) {
                pA = headB;
            }

            if (pB == null) {
                pB = headA;
            }

            //2位置
            pA = pA.next;
            pB = pB.next;
        }

        return pA;
    }
}
