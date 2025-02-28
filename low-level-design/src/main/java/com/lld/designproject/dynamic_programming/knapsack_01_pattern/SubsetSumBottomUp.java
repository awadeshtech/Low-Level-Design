package com.lld.designproject.dynamic_programming.knapsack_01_pattern;

public class SubsetSumBottomUp {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 7, 8, 10};
        int sum = 35;
        int n = 5;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0) {
                        dp[i][j] = false;
                    }
                    if (j == 0) {
                        dp[i][j] = true;
                    }
                } else {
                    if (arr[i - 1] <= j) {
                       dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                    } else {
                      dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }

        if (dp[n][sum]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
