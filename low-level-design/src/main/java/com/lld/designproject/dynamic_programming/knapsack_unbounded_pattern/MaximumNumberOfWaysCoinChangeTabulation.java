package com.lld.designproject.dynamic_programming.knapsack_unbounded_pattern;

public class MaximumNumberOfWaysCoinChangeTabulation {
    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 3};
        System.out.println(findNumberOfWays(coins, 5));

    }

    private static int findNumberOfWays(int[] coins, int sum) {
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0) {
                        dp[i][j] = 0;
                    }
                    if (j == 0) {
                        dp[i][j] = 1;
                    }
                } else {

                    if (coins[i - 1] <= j) {
                        dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }

            }
        }
        return dp[n][sum];
    }
}
