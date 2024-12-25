package com.dysjsjy;

import java.util.*;

public class bt107_1 {

    //正常层序遍历，最后反转
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
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

        Collections.reverse(res);
        return res;
    }

    //先获得整个树的深度，然后正常遍历，只是放的时候从最底层开始放
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        int height = getHeight(root);

        return res;
    }

    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    private void dfs(TreeNode root, int level , List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        res.get(level).add(root.val);
        dfs(root.left, level - 1, res);
        dfs(root.right, level - 1, res);
    }
}
