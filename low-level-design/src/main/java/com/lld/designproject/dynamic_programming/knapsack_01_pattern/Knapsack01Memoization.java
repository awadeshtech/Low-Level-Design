package com.lld.designproject.dynamic_programming.knapsack_01_pattern;

import java.util.Arrays;

public class Knapsack01Memoization {
    static int[][] dp;

    public static void main(String[] args) {
        int[] weight = new int[] {1, 3, 4, 5};
        int[] val = new int[] {1, 4, 5, 7};
        int W = 7;
        int n = 4;
        dp = new int[n + 1][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(knapsack01Memoization(weight, val, W, n));
    }

    private static int knapsack01Memoization(int[] weight, int[] value, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (weight[n - 1] <= W) {
            return dp[n][W] = Math.max(value[n - 1] + knapsack01Memoization(weight, value, W - weight[n - 1], n - 1),
                knapsack01Memoization(weight, value, W, n - 1));
        } else {
            return dp[n][W] = knapsack01Memoization(weight, value, W, n - 1);
        }
    }
}
