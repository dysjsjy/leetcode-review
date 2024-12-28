package com.dysjsjy;

public class bt110_1 {

    public boolean isBalanced(TreeNode root) {
        return travelTree(root) != -1;
    }

    int travelTree(TreeNode root) {
        if (root == null) return 0;

        int left = travelTree(root.left);
        if (left == -1) {
            return -1;
        }
        int right = travelTree(root.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
