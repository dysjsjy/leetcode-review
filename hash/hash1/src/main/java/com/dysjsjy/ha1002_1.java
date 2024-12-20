package com.dysjsjy;

import java.util.*;

public class ha1002_1 {

    //遍历字母在所有字符中出现的最小次数
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] freq = new int[26];

            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            for (int i = 0; i < minFreq.length; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < minFreq.length; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                if (minFreq[i] > 0 && minFreq[i] != Integer.MAX_VALUE) {
                    ans.add(String.valueOf((char) ('a' + i)));
                }
            }
        }

        return ans;
    }
}
