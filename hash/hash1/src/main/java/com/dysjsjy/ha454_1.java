package com.dysjsjy;

import java.util.HashMap;
import java.util.Map;

public class ha454_1 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums1.length;

        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int aws = 0;

        for (int i : nums3) {
            for (int j : nums4) {
                aws += map.getOrDefault(-(i + j), 0);
            }
        }

        return aws;
    }
}
