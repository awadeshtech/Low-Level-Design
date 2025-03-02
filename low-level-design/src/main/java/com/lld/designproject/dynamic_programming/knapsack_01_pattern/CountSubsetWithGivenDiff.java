package com.lld.designproject.dynamic_programming.knapsack_01_pattern;

public class CountSubsetWithGivenDiff {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 2, 3};
        System.out.println(countSubsetWithGivenDiff(arr, 1));

    }

    private static int countSubsetWithGivenDiff(int[] arr, int diff) {
        int n = arr.length;
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int s1 =
            (sum + diff) / 2; // s1-s2 = diff -> eq.1 and s1+s2 = sum -> eq.2 on adding 1 and 2 we get 2s1 = sum+diff

        int[][] dp = new int[n + 1][s1 + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= s1; j++) {
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

        return dp[n][s1];
    }
}
