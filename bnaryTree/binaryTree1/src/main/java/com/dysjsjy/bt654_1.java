package com.dysjsjy;

import java.util.Arrays;

public class bt654_1 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        if (n == 0) return null;
        int leftSize = indexOfMax(nums);
        int[] leftNums = Arrays.copyOfRange(nums, 0, leftSize);
        int[] rightNums = Arrays.copyOfRange(nums, leftSize + 1, n);
        TreeNode left = constructMaximumBinaryTree(leftNums);
        TreeNode right = constructMaximumBinaryTree(rightNums);
        return new TreeNode(nums[leftSize], left, right);
    }

    int indexOfMax(int[] its) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < its.length; i++) {
            if (its[i] > max) {
                max = its[i];
                index = i;
            }
        }
        return index;
    }
}
