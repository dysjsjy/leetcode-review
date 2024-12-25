package com.dysjsjy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bt102_1 {

    public List<List<Integer>> levelOrderD(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = queue.size();

            while (len-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.add(list);
        }

        return res;
    }

    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        travelTreeBFS(root, 0, res);

        return res;
    }

    void travelTreeBFS(TreeNode node, Integer deep, List<List<Integer>> res) {
        if (node == null) {
            return;
        }

        deep++;

        if (res.size() < deep) {
            List<Integer> item = new ArrayList<>();
            res.add(item);
        }

        res.get(deep - 1).add(node.val);

        travelTreeBFS(node.left, deep, res);
        travelTreeBFS(node.right, deep, res);
    }
}
