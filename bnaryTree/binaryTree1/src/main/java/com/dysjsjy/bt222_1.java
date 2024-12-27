package com.dysjsjy;

import java.util.LinkedList;
import java.util.Queue;

public class bt222_1 {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                count++;

                if (node.left != null) queue.add(node.left);

                if (node.right != null) queue.add(node.right);
            }
        }

        return count;
    }

    int travelTree(TreeNode root) {
        if (root == null) return 0;

        int left = travelTree(root.left);

        int right = travelTree(root.right);

        return left + right + 1;
    }
}
