package com.lld.designproject.dynamic_programming.knapsack_unbounded_pattern;

public class RodCutting {
    public static void main(String[] args) {
        int[] length = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        int[] prices = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = 8;
        System.out.println(rodCutting(length, prices, size));
    }

    private static int rodCutting(int[] length, int[] prices, int size) {
        int n = length.length;
        int[][] dp = new int[n + 1][size + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= size; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (length[i - 1] <= j) {
                        dp[i][j] = Math.max(prices[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[n][size];


    }
}
