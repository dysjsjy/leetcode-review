package com.dysjsjy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class bt144d_1 {

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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);

        while (!deque.isEmpty()) {
            TreeNode cur = deque.poll();

            res.add(cur.val);

            if (cur.right != null) {
                deque.push(cur.right);
            }

            if (cur.left != null) {
                deque.push(cur.left);
            }
        }

        return res;
    }
}
