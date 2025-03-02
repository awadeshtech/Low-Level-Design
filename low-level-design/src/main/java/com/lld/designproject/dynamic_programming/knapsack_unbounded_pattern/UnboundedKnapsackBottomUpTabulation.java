package com.lld.designproject.dynamic_programming.knapsack_unbounded_pattern;

public class UnboundedKnapsackBottomUpTabulation {
    public static void main(String[] args) {
        int[] weight = new int[] {1, 3, 4, 5};
        int[] val = new int[] {7, 4, 5, 7};
        int W = 7;
        System.out.println(unboundedKnapsackBottomUpTabulation(weight, val, W));
    }

    private static int unboundedKnapsackBottomUpTabulation(int[] weight, int[] val, int W) {
        int n = weight.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (weight[i - 1] <= j) {
                        dp[i][j] = Math.max(val[i - 1] + dp[i][j - weight[i - 1]], dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }

            }
        }

        return dp[n][W];

    }
}
