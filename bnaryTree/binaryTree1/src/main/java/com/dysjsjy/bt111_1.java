package com.dysjsjy;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class bt111_1 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            TreeNode node = current.getKey();
            int depth = current.getValue();

            if (node.left == null && node.right == null) {
                return depth;
            }

            if (node.left != null) {
                queue.add(new Pair<>(node.left, depth + 1));
            }

            if (node.right != null) {
                queue.add(new Pair<>(node.right, depth + 1));
            }
        }

        return 0;
    }

    //错误示范，无法处理只有一条边的情况
    int travelTreeX(TreeNode root, int deep) {
        if (root == null) {
            return deep - 1;
        }

        int leftDepth = travelTreeX(root.left, deep + 1);
        int rightDepth = travelTreeX(root.right, deep + 1);

        return Math.min(leftDepth, rightDepth);
    }

    int travelTree(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = travelTree(root.left);
        int rightDepth = travelTree(root.right);

        return Math.min(leftDepth, rightDepth) + 1;
    }
}
