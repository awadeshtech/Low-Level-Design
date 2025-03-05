package com.lld.designproject.dynamic_programming.knapsack_unbounded_pattern;

public class MinimumNumberOfCoinsBottomUpTabulation {
    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 5};
        int amount = 11;
        System.out.println(findMinimumNumberOfCoins(coins, amount));
    }

    private static int findMinimumNumberOfCoins(int[] coins, int amount) {
        int size = coins.length;
        int[][] dp = new int[size + 1][amount + 1];

        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[size][amount];
    }
}
