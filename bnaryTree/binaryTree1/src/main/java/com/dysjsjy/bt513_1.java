package com.dysjsjy;

import java.util.LinkedList;
import java.util.Queue;

public class bt513_1 {


    public int findBottomLeftValue(TreeNode root) {
        int aws = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            TreeNode node = queue.peek();
            if (node != null) {
                aws = node.val;
            }
            while (len-- > 0) {
                node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return aws;
    }

    //灵神
    public int findBottomLeftValue2(TreeNode root) {
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (root.right != null) {
                queue.add(root.right);
            }
            if (root.left != null) {
                queue.add(root.left);
            }
        }

        return node.val;
    }
}
