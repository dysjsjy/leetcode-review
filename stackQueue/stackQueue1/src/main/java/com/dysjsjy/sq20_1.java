package com.dysjsjy;

import java.util.Deque;
import java.util.LinkedList;

public class sq20_1 {

    //参考
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();

        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '{') {
                deque.push('}');
            } else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            } else {
                deque.pop();
            }
        }

        return deque.isEmpty();
    }

    //我的
    public boolean isValid2(String s) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                deque.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (deque.isEmpty()) {
                    return false;
                }
                char c = deque.pop();
                if (c == '(') {
                    continue;
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (deque.isEmpty()) {
                    return false;
                }
                char c = deque.pop();
                if (c == '{') {
                    continue;
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (deque.isEmpty()) {
                    return false;
                }
                char c = deque.pop();
                if (c == '[') {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }
}
