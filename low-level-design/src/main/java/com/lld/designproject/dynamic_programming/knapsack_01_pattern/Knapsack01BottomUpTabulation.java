package com.lld.designproject.dynamic_programming.knapsack_01_pattern;

public class Knapsack01BottomUpTabulation {
    public static void main(String[] args) {
        int[] weight = new int[] {1, 3, 4, 5};
        int[] val = new int[] {1, 4, 5, 7};
        int W = 7;
        int n = 4;
        int[][] dp = new int[n + 1][W + 1];
        /**
         --- 0 1 2 3 4 5 6 7
        0
        1
        2
        3
        4
         */

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (weight[i-1] <= j) {
                        dp[i][j] = Math.max(val[i-1] + dp[i - 1][j - weight[i-1]], dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[n][W]);
    }
}
