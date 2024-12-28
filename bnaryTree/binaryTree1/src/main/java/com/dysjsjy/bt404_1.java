package com.dysjsjy;

public class bt404_1 {

    public int sumOfLeftLeaves(TreeNode root) {
        int[] aws = new int[1];

        travelTree(root, aws);

        return aws[0];
    }

    void travelTree(TreeNode root, int[] aws) {

        if (root == null) return;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            aws[0] += root.left.val;
        }

        travelTree(root.left, aws);
        travelTree(root.right, aws);
    }
}
