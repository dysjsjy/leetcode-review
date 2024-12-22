package com.dysjsjy;

public class dpo344_1 {

    public void reverseString(char[] s) {
        int left = 0;

        for (int right = s.length - 1; right > left; right--) {
            char temp  = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
        }
    }
}
