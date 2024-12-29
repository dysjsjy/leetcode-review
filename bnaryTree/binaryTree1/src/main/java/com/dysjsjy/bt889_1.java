package com.dysjsjy;

import java.util.Arrays;

public class bt889_1 {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        if (n == 0) return null;
        if (n == 1) return new TreeNode(preorder[0]);
        int leftSize = indexOf(postorder, preorder[1]) + 1;
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize, n - 1);
        TreeNode left = constructFromPrePost(pre1, post1);
        TreeNode right = constructFromPrePost(pre2, post2);
        return new TreeNode(preorder[0], left, right);
    }

    int indexOf(int[] its, int val) {
        for (int i = 0;; i++) {
            if (its[i] == val) return i;
        }
    }
}
