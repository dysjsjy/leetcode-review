package com.dysjsjy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ha202_1 {

    public boolean isHappy(int n) {
        Set<Integer> seem = new HashSet<>();

        while (n != 1 && !seem.contains(n)) {
            seem.add(n);

            n = getNext(n);
        }

        return n == 1;
    }

    int getNext(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}

/*
错误示范

 static List<Integer> nums = new ArrayList<>();

    public boolean isHappy(int n) {
        int cal = n;

        for (int i = 0; i < 10; i++) {
            getAllNum(cal);

            int curNum = 0;

            for (int num : nums) {
                curNum += num * num;
            }

            if (curNum == 1) {
                return true;
            }
        }

        return false;
    }

    void getAllNum(int cal) {
        nums.clear();

        while (cal / 10 != 0) {
            int curNum = cal % 10;
            cal -= curNum;
            cal = cal / 10;

            nums.add(curNum);
        }
    }
 */