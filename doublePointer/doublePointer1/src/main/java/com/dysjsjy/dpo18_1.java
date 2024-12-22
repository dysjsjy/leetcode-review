package com.dysjsjy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dpo18_1 {

    //也是很固定的写法
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> aws = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > target && nums[i] >= 0) break;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] > target && nums[i] + nums[j] >= 0) break;

                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        aws.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }

        return aws;
    }
}
