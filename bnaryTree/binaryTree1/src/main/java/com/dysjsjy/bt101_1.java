package com.dysjsjy;

public class bt101_1 {

    public boolean isSymmetric(TreeNode root) {
        TreeNode leftTree = root.left;
        TreeNode rightTree = root.right;

        return travelTwoTree(leftTree, rightTree);
    }

    boolean travelTwoTree(TreeNode leftTree, TreeNode rightTree) {

        if (leftTree == null && rightTree != null) {
            return false;
        }
        if (leftTree != null && rightTree == null) {
            return false;
        }
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree.val != rightTree.val) {
            return false;
        }

        boolean one = travelTwoTree(leftTree.left, rightTree.right);
        boolean two = travelTwoTree(leftTree.right, rightTree.left);

        return one && two;
    }
}
