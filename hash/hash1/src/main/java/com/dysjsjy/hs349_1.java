package com.dysjsjy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class hs349_1 {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> integers1 = new HashSet<>();
        HashSet<Integer> integers2 = new HashSet<>();

        for (int i : nums1) {
            integers1.add(i);
        }

        for (int i : nums2) {
            integers2.add(i);
        }

        List<Integer> aws = new ArrayList<>();

        for (int i : integers1) {
            if (integers2.contains(i)) {
                aws.add(i);
            }
        }

        return aws.stream().mapToInt(i -> i).toArray();
    }
}
