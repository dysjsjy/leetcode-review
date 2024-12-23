package com.dysjsjy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class sq239_1 {

    private class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        void poll (int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }

        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }

            deque.add(val);
        }

        int peek() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }

        int len = nums.length -k + 1;

        int[] res = new int[len];
        int num = 0;

        MyQueue myQueue = new MyQueue();

        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }

        res[num++] = myQueue.peek();

        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            res[num++] = myQueue.peek();
        }

        return res;
    }

    private class Solution {

        //利用双端队列手动实现单调队列
        public int[] maxSlidingWindow(int[] nums, int k) {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            int n = nums.length;
            int[] res = new int[n - k + 1];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                    deque.poll();
                }

                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }

                deque.add(i);

                if (i >= k - 1) {
                    res[idx++] = nums[deque.peek()];
                }
            }

            return res;
        }
    }

}
