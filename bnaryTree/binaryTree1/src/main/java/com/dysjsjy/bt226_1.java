package com.dysjsjy;

public class bt226_1 {

    public TreeNode invertTree(TreeNode root) {
        travelTree(root);

        return root;
    }

    void travelTree(TreeNode cur) {
        if (cur == null) {
            return;
        }

        TreeNode temp = new TreeNode();
        temp = cur.left;
        cur.left = cur.right;
        cur.right = temp;

        if (cur.left != null) {
            travelTree(cur.left);
        }

        if (cur.right != null) {
            travelTree(cur.right);
        }
    }
}
