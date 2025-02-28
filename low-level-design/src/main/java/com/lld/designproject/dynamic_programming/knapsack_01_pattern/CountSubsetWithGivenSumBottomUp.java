package com.lld.designproject.dynamic_programming.knapsack_01_pattern;

public class CountSubsetWithGivenSumBottomUp {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 5, 6, 8, 10};
        int sum = 10;
        int n = arr.length;
        System.out.println(bottomUp(arr, sum, n));
    }

    private static int bottomUp(int[] arr, int sum, int n) {
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
                    if (arr[i - 1] <= j) {
                        dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][sum];
    }
}
