package com.dysjsjy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bt501_1 {

    List<Integer> answer = new ArrayList<>();
    int base, count, maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    void dfs(TreeNode o) {
        if (o == null) return;

        dfs(o.left);
        update(o.val);
        dfs(o.right);
    }

    void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }
}
