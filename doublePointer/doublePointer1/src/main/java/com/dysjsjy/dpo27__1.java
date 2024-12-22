package com.dysjsjy;

public class dpo27__1 {
    public int removeElement(int[] nums, int val) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
        }

        return left;
    }
}
