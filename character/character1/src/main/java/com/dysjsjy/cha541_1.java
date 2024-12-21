package com.dysjsjy;

public class cha541_1 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i += 2 * k) {
            int right = 0;
            right = Math.min(i + k -1, chars.length - 1);
            int left = i;

            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }
}
//错误示范
/*
public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = 0;

        while (right < chars.length) {
            if (right + 2 * k < chars.length) {
                int curRight = right;
                right += k;

                while (left < right) {
                    char temp = chars[left];
                    chars[left++] = chars[right];
                    chars[right--] = temp;
                }

                right = curRight + k;
                left = right;
            } else if (right + k > chars.length) {
                right = chars.length - 1;

                while (left < right) {
                    char temp = chars[left];
                    chars[left++] = chars[right];
                    chars[right--] = temp;
                }

                break;
            } else if (right + 2 * k > chars.length) {
                right += k;

                while (left < right) {
                    char temp = chars[left];
                    chars[left++] = chars[right];
                    chars[right--] = temp;
                }

                break;
            }
        }

        return new String(chars);
    }
 */