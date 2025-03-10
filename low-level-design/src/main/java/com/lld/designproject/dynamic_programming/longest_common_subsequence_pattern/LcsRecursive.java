package com.lld.designproject.dynamic_programming.longest_common_subsequence_pattern;

public class LcsRecursive {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        System.out.println(recursive(s1Array, s2Array, s1Array.length, s2Array.length));
    }

    private static int recursive(char[] s1, char[] s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (s1[m - 1] == s2[n - 1]) {
            return 1 + recursive(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(recursive(s1, s2, m - 1, n), recursive(s1, s2, m, n - 1));
        }
    }
}
