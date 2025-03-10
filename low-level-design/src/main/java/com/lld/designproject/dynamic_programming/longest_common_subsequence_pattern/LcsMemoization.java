package com.lld.designproject.dynamic_programming.longest_common_subsequence_pattern;

import java.util.Arrays;

public class LcsMemoization {
    static int[][] dp;

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        int m = s1.length();
        int n = s2.length();
        dp = new int[m + 1][n + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        System.out.println(lcsMemoized(s1Array, s2Array, m, n));
    }

    private static int lcsMemoized(char[] s1, char[] s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (s1[m - 1] == s2[n - 1]) {
            return dp[m][n] = 1 + lcsMemoized(s1, s2, m - 1, n - 1);
        } else {
            return dp[m][n] = Math.max(lcsMemoized(s1, s2, m - 1, n), lcsMemoized(s1, s2, m, n - 1));
        }
    }
}
