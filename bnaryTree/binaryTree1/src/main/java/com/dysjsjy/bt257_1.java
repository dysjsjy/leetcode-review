package com.dysjsjy;

import java.util.ArrayList;
import java.util.List;

public class bt257_1 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> intsList = new ArrayList<>();
        travelTree(root, res, intsList);
        return res;
    }

    void travelTree(TreeNode root, List<String> res, List<Integer> intsList) {
        intsList.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < intsList.size() - 1; i++) {
                sb.append(intsList.get(i));
                sb.append("->");
            }

            sb.append(intsList.get(intsList.size() - 1));

            res.add(sb.toString());
        }

        if (root.left != null) {
            travelTree(root.left, res, intsList);
            intsList.remove(intsList.size() - 1);
        }

        if (root.right != null) {
            travelTree(root.right, res, intsList);
            intsList.remove(intsList.size() - 1);
        }
    }
}
