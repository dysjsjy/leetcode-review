package com.dysjsjy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class dpo15_1 {

    //其实也是一个很固定的写法
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> aws = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) {
                continue;
            }
            if (x + nums[i + 1] + nums[i + 2] > 0) break;
            if (x + nums[n - 2] + nums[n - 1] < 0) continue;
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int s = x + nums[j] + nums[k];
                if (s > 0) {
                    k--;
                } else if (s < 0) {
                    j++;
                } else {
                    aws.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    for (j++; j < k && nums[j] == nums[j - 1]; j++); //跳过重复数字
                    for (k--; k > j && nums[k] == nums[k + 1]; k--); //跳过重复数字
                }
            }
        }

        return aws;
    }

    //暴力解法
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> lists = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j +1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);

                        if (!lists.contains(list)) {
                            res.add(list);
                            lists.add(list);
                        }
                    }
                }
            }
        }

        return res;
    }
}
