package com.dysjsjy;

/*
59. 螺旋矩阵 II
中等
相关标签
相关企业
给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class ar59_1 {

    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0;
        int offset = 1;
        int count = 1;
        int loop = 1;
        int i, j;

        while (loop <= n/2) {

            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }

            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            for (; i > startX; i--) {
                nums[i][j] = count++;
            }

            startX++;
            startY++;
            offset++;
            loop++;
        }

        if (n % 2 == 1) {
            nums[startX][startY] = count;
        }
        return nums;
    }
}
