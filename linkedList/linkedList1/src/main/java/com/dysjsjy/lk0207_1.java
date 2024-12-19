package com.dysjsjy;

public class lk0207_1 {

    //这居然是道简单题？
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //快慢指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        if (pA == null || pB == null) {
            return null;
        }

        while (pA !=null || pB != null) {
            pA = pA.next;
            pB = pB.next;
        }

        int count = 0;

        if (pA == null) {
            while (pB != null) {
                pB = pB.next;
                count++;
            }

            pA = headA;
            pB = headB;

            for (int i = 0; i < count; i++) {
                pB = pB.next;
            }

            while (true) {
                if (pA == pB) {
                    return pA;
                }
                pA = pA.next;
                pB = pB.next;
            }
        } else if (pB == null) {
            while (pA != null) {
                pA = pA.next;
                count++;
            }

            pA = headA;
            pB = headB;

            for (int i = 0; i < count; i++) {
                pA = pA.next;
            }

            while (true) {
                if (pA == pB) {
                    return pA;
                }
                pA = pA.next;
                pB = pB.next;
            }

        } else if (pA == null && pB == null) {
            pA = headA;
            pB = headB;
            while (true) {
                if (pA == pB) {
                    return pA;
                }
                pA = pA.next;
                pB = pB.next;
            }
        }

        return null;
    }
}
