package com.lld.designproject.dynamic_programming.knapsack_01_pattern;

public class SubsetSumRecursive {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 7, 8, 10};
        int sum = 35;
        if (subsetSumRecursive(arr, 5, sum)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
   // time complexity 2^n as each element has two choices , include or exclude
    private static boolean subsetSumRecursive(int[] arr, int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (arr[n - 1] <= sum) {
            return subsetSumRecursive(arr, n - 1, sum - arr[n - 1]) || subsetSumRecursive(arr, n - 1, sum);
        } else {
            return subsetSumRecursive(arr, n - 1, sum);
        }
    }
}
