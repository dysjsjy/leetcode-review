package com.dysjsjy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class sq150_1 {

    //我的
    public int evalRPN(String[] tokens) {

        Deque<Long> deque = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            long sum = 0;

            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                deque.push(Long.valueOf(tokens[i]));
            } else {
                long y = deque.pop();
                long x = deque.pop();

                char op = tokens[i].charAt(0);

                switch (op) {
                    case '+':
                        sum = x + y;
                        break;
                    case '-':
                        sum = x - y;
                        break;
                    case '*':
                        sum = (long) x * y;
                        break;
                    case '/':
                        sum = x / y;
                        break;
                    default:
                        break;
                }

                deque.push(sum);
            }
        }

        return Math.toIntExact(deque.pop());
    }

    //示范
    public int evalRPN2(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (String s : tokens) {
            if ("+".equals(s)) {        // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
