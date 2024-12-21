package com.dysjsjy;

public class cha28_1 {

    //暴力解法
    public int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {

            int curhay = i;
            if (haystack.charAt(curhay) == needle.charAt(0)) {
                for (int j = 0; j < needle.length(); j++) {
                    if (curhay > haystack.length() - 1 || haystack.charAt(curhay) != needle.charAt(j)) {
                        break;
                    }

                    curhay += 1;

                    if (j == needle.length() - 1) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }

    //KMP
    public int strStr2(String haystack, String needle) {
        if (needle.isEmpty()) {
            return -1;
        }
        int m = haystack.length(), n = needle.length();

        //构建部分匹配表，next数组
        int[] next = new int[n];
        buildNext(needle, next);

        //匹配过程
        int i = 0, j = 0;
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }

            //完全匹配
            if (j == n) {
                return i - n;
            }
        }

        return -1;
    }

    //构建next数组
    private void buildNext(String needle, int[] next) {
        int j = 0; //当前最长前后缀长度
        next[0] = 0;

        for (int i = 1; i < needle.length(); i++) {
            //不匹配时回退
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = next[j - 1];
            }

            //匹配成功，最长前后缀长度 +1
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }

            next[i] = j;
        }
    }
}
