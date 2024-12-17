package com.dysjsjy;

import java.util.Scanner;

public class ar_acm58_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nums = new int[n];
        int[] prefix_sum = new int[n];

        nums[0] = scanner.nextInt();
        prefix_sum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            nums[i] = scanner.nextInt();
            prefix_sum[i] = prefix_sum[i - 1] + nums[i];
        }

        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int sum = prefix_sum[b] - (a > 0 ? prefix_sum[a - 1] : 0);
            System.out.println(sum);
        }

        scanner.close();
    }
}
