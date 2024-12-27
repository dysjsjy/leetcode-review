package com.dysjsjy;

import java.util.LinkedList;
import java.util.Queue;

public class bt104_1 {

    public int maxDepth(TreeNode root) {
//        return travelTree(root, 1);


        if (root == null) return 0;
        int deep = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            deep++;
        }

        return deep;
    }

    int travelTree(TreeNode cur, int deep) {
        if (cur == null) {
            return deep - 1;
        }

        int leftDeep = travelTree(cur.left, deep + 1);
        int rightDeep = travelTree(cur.right, deep + 1);

        return Math.max(leftDeep, rightDeep);
    }
}
