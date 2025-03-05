package com.lld.designproject.dynamic_programming.knapsack_01_pattern;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubsetSumDifferenceBottomUp {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 7, 2};
        System.out.println(findMinimumSubsetSumDifference(arr));
    }

    private static int findMinimumSubsetSumDifference(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int i : arr) {
            sum += i;
        }
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
                        dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        //s2-s1 should be minimum, here sum of all the elements
        // will be considered as range. So, range = s1+s2, s2 = range-s1,Minimum of (Range-s1-s1 =range-s2)
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[n][i]) {
                candidates.add(i);
            }
        }

        for (int candidate : candidates) {
            ans = Math.min(ans, (sum - 2 * candidate));
        }
        return ans;
    }
}
