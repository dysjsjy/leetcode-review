package com.dysjsjy;

public class cha459_1 {

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length() / 2; i++) {
            if (s.length() % i == 0) {
                String temp = s.substring(0, i);
                int count = s.length() / i;
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < count; j++) {
                    sb.append(temp);
                }

                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }

    //错误示范
    public boolean repeatedSubstringPattern2(String s) {
        //1不用判断
        if (s.length() == 1) {
            return false;
        }
        //不需要遍历整个数组，超过一半就没有判断意义了
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(0, i + 1);

            if (s.length() % temp.length() == 0) {
                int count = s.length() / temp.length();
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < count; j++) {
                    sb.append(temp);
                }

                if (sb.toString().equals(s)) {
                    return true;
                }
                //else错误，会跳出整个循环
            } else {
                break;
            }
        }

        return false;
    }
}
