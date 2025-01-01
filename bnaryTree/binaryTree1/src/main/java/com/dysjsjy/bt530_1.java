package com.dysjsjy;

public class bt530_1 {

    private int min = Integer.MAX_VALUE;
    private Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        travleTree(root);
        return min;
    }

    void travleTree(TreeNode root) {
        if (root == null) {
            return;
        }

        travleTree(root.left);

        if (prev != null) {
            min = Math.min(min, Math.abs(root.val - prev));
        }

        prev = root.val;

        travleTree(root.right);
    }
}
