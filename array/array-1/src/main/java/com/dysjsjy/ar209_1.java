package com.dysjsjy;


/*
209. 长度最小的子数组
已解答
中等
相关标签
相关企业
给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其总和大于等于 target 的长度最小的
子数组
 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class ar209_1 {
    //正确示范
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int n = nums.length;
        int sum = 0;
        int minResult = n + 1;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum >= target) {
                minResult = Math.min(minResult, right - left + 1);
                sum -= nums[left++];
            }
        }

        return minResult <= n ? minResult : 0;
    }

    //解法2
    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0;
        int n = nums.length;
        int sum = 0;
        int minResult = n + 1;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum >= target) {
                sum -= nums[left++];
            }

            //这里是防止压根没进while循环的情况
            if (sum >= target) {
                minResult = Math.min(minResult, right - left + 1);
            }
        }

        return minResult <= n ? minResult : 0;
    }
}
