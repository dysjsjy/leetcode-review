package com.dysjsjy;

import java.util.ArrayList;
import java.util.List;

public class bt199_1 {
    //来自灵神
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        dfs(root, 0, res);

        return res;
    }

    void dfs(TreeNode root, int deep, List<Integer> res) {
        if (root == null) return;

        if (deep == res.size()) res.add(root.val);

        dfs(root.right, deep + 1, res);
        dfs(root.left, deep + 1, res);
    }
}
