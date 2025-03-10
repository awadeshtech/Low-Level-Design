package com.lld.designproject.dynamic_programming.longest_common_subsequence_pattern;

public class LongestCommonSubstringBottomUpTabulation {
    public static void main(String[] args) {
        String s1 = "lmnopabcdgh";
        String s2 = "lmnopabedfhr";
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        System.out.println(findCommonSubstringLength(s1Array, s2Array));
    }

    private static int findCommonSubstringLength(char[] s1, char[] s2) {
        int m = s1.length;
        int n = s2.length;
        int ans = Integer.MIN_VALUE;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (s1[i - 1] == s2[j - 1]) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        ans = Math.max(ans, dp[i][j]);
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
