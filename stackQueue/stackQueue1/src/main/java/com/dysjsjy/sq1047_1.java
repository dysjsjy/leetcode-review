package com.dysjsjy;

import java.util.Deque;
import java.util.LinkedList;

public class sq1047_1 {

    public String removeDuplicates(String s) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (!deque.isEmpty() && deque.peek() == s.charAt(i)) {
                deque.remove();
            } else {
                deque.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pop());
        }

        return sb.reverse().toString();
    }
}
