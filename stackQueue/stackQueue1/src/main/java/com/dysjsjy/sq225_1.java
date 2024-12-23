package com.dysjsjy;

import java.util.LinkedList;
import java.util.Queue;

public class sq225_1 {

    private static class MyStack {

        private Queue<Integer> inQueue;
        private Queue<Integer> outQueue;
        int size;

        public MyStack() {
            this.inQueue = new LinkedList<Integer>();
            this.outQueue = new LinkedList<>();
            this.size = 0;
        }

        public void push(int x) {
            this.inQueue.add(x);
            size += 1;
        }

        public int pop() {
            for (int i = 0; i < size - 1; i++) {
                this.outQueue.add(this.inQueue.poll());
            }

            int res = this.inQueue.poll();

            size -= 1;

            for (int i = 0; i < size; i++) {
                this.inQueue.add(this.outQueue.poll());
            }

            return res;
        }

        public int top() {
            for (int i = 0; i < size - 1; i++) {
                this.outQueue.add(this.inQueue.poll());
            }

            int res = this.inQueue.peek();

            this.outQueue.add(this.inQueue.poll());

            for (int i = 0; i < size; i++) {
                this.inQueue.add(this.outQueue.poll());
            }

            return res;
        }

        public boolean empty() {
            return size == 0;
        }
    }
}
