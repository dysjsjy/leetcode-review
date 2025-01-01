package com.dysjsjy;

public class bt98_1 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long left, long right) {
        if (node == null) return true;

        long x = node.val;
        return left < x && right > x &&
                isValidBST(node.left, left, x) &&
                isValidBST(node.right, x, right);
    }
}
