package com.dysjsjy;

import java.util.ArrayList;
import java.util.List;

public class cha151_1 {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        List<String> stringList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int begin = 0;
        while (chars[begin] == ' ') {
            begin++;
        }

        for (int i = begin; i < chars.length; i++) {
            if (i > 0 &&chars[i] == chars[i - 1] && chars[i] == ' ') {
                continue;
            }
            if (chars[i] == ' ') {
                stringList.add(sb.toString());
                sb.delete(0, sb.length());

                if (i == chars.length - 1) {
                    break;
                }
            } else {
                sb.append(chars[i]);
            }

            if (i == chars.length - 1) {
                stringList.add(sb.toString());
            }
        }

        int left = 0;
        int right = stringList.size() - 1;

        while (left < right) {
            String temp = stringList.get(left);
            stringList.set(left, stringList.get(right));
            stringList.set(right, temp);
            left++;
            right--;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < stringList.size(); i++) {
            builder.append(stringList.get(i));
            if (i != stringList.size() - 1) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "t ";
        new cha151_1().reverseWords(s);
    }

    //优化后的版本二
    public String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        // 1. 去除首尾空格
        int left = 0, right = n - 1;
        while (left <= right && chars[left] == ' ') left++;
        while (left <= right && chars[right] == ' ') right--;

        // 2. 手动分割单词
        List<String> wordList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        while (left <= right) {
            char c = chars[left];

            // 遇到空格，保存单词
            if (c == ' ') {
                if (sb.length() > 0) {
                    wordList.add(sb.toString());
                    sb.setLength(0);  // 清空 StringBuilder
                }
            } else {
                sb.append(c);
            }
            left++;
        }
        // 最后一个单词
        if (sb.length() > 0) {
            wordList.add(sb.toString());
        }

        // 3. 手动反转单词列表
        int l = 0, r = wordList.size() - 1;
        while (l < r) {
            String temp = wordList.get(l);
            wordList.set(l, wordList.get(r));
            wordList.set(r, temp);
            l++;
            r--;
        }

        // 4. 拼接结果
        sb.setLength(0);
        for (int i = 0; i < wordList.size(); i++) {
            sb.append(wordList.get(i));
            if (i < wordList.size() - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
