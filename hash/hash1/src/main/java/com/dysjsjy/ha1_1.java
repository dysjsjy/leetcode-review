package com.dysjsjy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ha1_1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> intsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            intsMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (intsMap.containsKey(target - nums[i]) && i != intsMap.get(target - nums[i])) {
                return new int[]{intsMap.get(target - nums[i]), i};
            }
        }

        return null;
    }
}
