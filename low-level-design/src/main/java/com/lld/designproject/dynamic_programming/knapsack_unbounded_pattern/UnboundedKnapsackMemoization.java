package com.lld.designproject.dynamic_programming.knapsack_unbounded_pattern;

import java.util.Arrays;

public class UnboundedKnapsackMemoization {
    static int[][] dp;

    public static void main(String[] args) {
        int[] weight = new int[] {1, 3, 4, 5};
        int[] val = new int[] {7, 4, 5, 7};
        int W = 7;
        dp = new int[5][8];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(unboundedKnapsackMemoization(weight, val, W, 4));
    }

    private static int unboundedKnapsackMemoization(int[] weight, int[] val, int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (weight[n - 1] <= W) {
            return dp[n][W] = Math.max(val[n - 1] + unboundedKnapsackMemoization(weight, val, W - weight[n - 1], n),
                unboundedKnapsackMemoization(weight, val, W, n - 1));
        } else {
            return unboundedKnapsackMemoization(weight, val, W, n - 1);
        }
    }
}
