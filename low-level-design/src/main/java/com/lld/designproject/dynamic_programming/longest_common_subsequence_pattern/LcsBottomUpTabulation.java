package com.lld.designproject.dynamic_programming.longest_common_subsequence_pattern;

import java.util.Arrays;

public class LcsBottomUpTabulation {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        int m = s1.length();
        int n = s2.length();
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        System.out.println(lcsTabulationBottomUp(s1Array, s2Array, m, n));
    }

    private static int lcsTabulationBottomUp(char[] s1, char[] s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];

    }
}
