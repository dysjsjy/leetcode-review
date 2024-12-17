package com.dysjsjy;


import java.util.Scanner;

/*
44. 开发商购买土地（第五期模拟笔试）
题目描述
在一个城市区域内，被划分成了n * m个连续的区块，每个区块都拥有不同的权值，代表着其土地价值。目前，有两家开发公司，A 公司和 B 公司，希望购买这个城市区域的土地。

现在，需要将这个城市区域的所有区块分配给 A 公司和 B 公司。

然而，由于城市规划的限制，只允许将区域按横向或纵向划分成两个子区域，而且每个子区域都必须包含一个或多个区块。 为了确保公平竞争，你需要找到一种分配方式，使得 A 公司和 B 公司各自的子区域内的土地总价值之差最小。

注意：区块不可再分。

输入描述
第一行输入两个正整数，代表 n 和 m。

接下来的 n 行，每行输出 m 个正整数。

输出描述
请输出一个整数，代表两个子区域内土地总价值之间的最小差距。
 */
public class ar_acm44_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] grid = new int[n][m];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
                sum += grid[i][j];
            }
        }

        //两种分割方式
        int[] horizontal = new int[n];
        int[] vertical = new int[m];

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                horizontal[i] += grid[i][j];
                vertical[j] += grid[i][j];
            }
        }

        int hsum = 0;
        int vsum = 0;

        for (int i = 0; i < n; i++) {
            hsum += horizontal[i];
            result = Math.min(result, Math.abs(sum - hsum *2));
        }

        for (int i = 0; i < m; i++) {
            vsum += vertical[i];
            result = Math.min(result, Math.abs(sum - vsum *2));
        }

        System.out.println(result);
        scanner.close();
    }
}
