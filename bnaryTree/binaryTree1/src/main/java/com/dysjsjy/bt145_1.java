package com.dysjsjy;

import java.util.ArrayList;
import java.util.List;

public class bt145_1 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;

        travelTree(cur, res);

        return res;
    }

    void travelTree(TreeNode cur, List<Integer> res) {
        if (cur == null) {
            return;
        }

        if (cur.left != null) {
            travelTree(cur.left, res);
        }

        if (cur.right != null) {
            travelTree(cur.right, res);
        }

        res.add(cur.val);
    }
}
