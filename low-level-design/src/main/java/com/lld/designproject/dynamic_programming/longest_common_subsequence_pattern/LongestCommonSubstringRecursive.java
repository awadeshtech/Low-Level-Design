package com.lld.designproject.dynamic_programming.longest_common_subsequence_pattern;

public class LongestCommonSubstringRecursive {
    int ans = Integer.MIN_VALUE;

    public static void main(String[] args) {
        String s1 = "lmnopabcdgh";
        String s2 = "lmnopabedfhr";
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        System.out.println(recursive(s1Array, s2Array, s1Array.length, s2Array.length, 0));
    }

    private static int recursive(char[] s1, char[] s2, int m, int n, int count) {
        if (m == 0 || n == 0) {
            return count;
        }

        if (s1[m - 1] == s2[n - 1]) {
            count = recursive(s1, s2, m - 1, n - 1, count + 1);
        }

        return Math.max(count, Math.max(recursive(s1, s2, m - 1, n, 0), recursive(s1, s2, m, n - 1, 0)));
    }
}
