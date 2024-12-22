package com.dysjsjy;

import java.util.ArrayList;
import java.util.List;

public class dpo151_1 {

    public String reverseWords(String s) {
        int begin = 0;
        int end = s.length() - 1;

        while (s.charAt(begin) == ' ') {
            begin++;
        }

        while (s.charAt(end) == ' ') {
            end--;
        }

        List<String> stringList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = begin; i <= end; i++) {
            if (i > 0 && s.charAt(i) == ' ' && s.charAt(i - 1) == ' ') {
                continue;
            } else if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == ' ') {
                stringList.add(sb.toString());
                sb.setLength(0);
            }

            if (i == end) {
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

        StringBuilder aws = new StringBuilder();

        for (int i = 0; i < stringList.size(); i++) {
            aws.append(stringList.get(i));


            if (i == stringList.size() - 1) {
                break;
            }

            aws.append(" ");
        }

        return aws.toString();
    }
}
