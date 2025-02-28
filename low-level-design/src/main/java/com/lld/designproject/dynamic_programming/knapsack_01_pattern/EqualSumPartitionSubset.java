package com.lld.designproject.dynamic_programming.knapsack_01_pattern;

public class EqualSumPartitionSubset {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 5, 8, 16};

        if (isEqualSumPartitionPossible(arr)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isEqualSumPartitionPossible(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0) {
                        dp[i][j] = false;
                    }
                    if (j == 0) {
                        dp[i][j] = true;
                    }
                } else {
                    if (arr[i - 1] <= j) {
                        dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][target];
    }
}
