package com.dysjsjy;

import java.util.Deque;
import java.util.LinkedList;

public class sq232_1 {

    private static class MyQueue {

        private Deque<Integer> inDeque;
        private Deque<Integer> outDeque;

        public MyQueue() {
            this.inDeque = new LinkedList<>();
            this.outDeque = new LinkedList<>();
        }

        //这样写其实压力全在push这里了
        public void push(int x) {
            this.inDeque.clear();

            while (!this.outDeque.isEmpty()) {
                this.inDeque.push(this.outDeque.pop());
            }

            this.inDeque.push(x);

            while (!this.inDeque.isEmpty()) {
                this.outDeque.push(this.inDeque.pop());
            }
        }

        public int pop() {
            return this.outDeque.pop();
        }

        public int peek() {
            return this.outDeque.peek();
        }

        public boolean empty() {
            return this.outDeque.isEmpty();
        }
    }
}
