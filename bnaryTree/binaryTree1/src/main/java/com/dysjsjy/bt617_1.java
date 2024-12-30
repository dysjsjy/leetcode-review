package com.dysjsjy;

public class bt617_1 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        int val = 0;

        TreeNode left = null;
        TreeNode right = null;

        if (root1 != null && root2 != null) {
            val = root1.val + root2.val;
            left = mergeTrees(root1.left, root2.left);
            right = mergeTrees(root1.right, root2.right);
        }

        if (root1 != null && root2 == null) {
            val = root1.val;
            left = mergeTrees(root1.left, null);
            right = mergeTrees(root1.right, null);
        }

        if (root1 == null && root2 != null) {
            val = root2.val;
            left = mergeTrees(null, root2.left);
            right = mergeTrees(null, root2.right);
        }

        return new TreeNode(val, left, right);
    }
}
