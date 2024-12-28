package com.dysjsjy;


public class bt112_1 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return travelTree(root, 0, targetSum);
    }

    boolean travelTree(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return false;
        }

        sum += root.val;

        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                return true;
            }
        }

        return travelTree(root.left, sum, targetSum) || travelTree(root.right, sum, targetSum);
    }
}
