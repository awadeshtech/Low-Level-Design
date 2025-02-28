package com.lld.designproject.dynamic_programming.knapsack_01_pattern;

public class CountSubsetWithGivenSumRecursive {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 5, 6, 8, 10};
        int sum = 10;
        int n = arr.length;

        System.out.println(recursive(arr, sum, n));
    }

    private static int recursive(int[] arr, int sum, int n) {

        if (sum == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        if (arr[n - 1] <= sum) {
            return recursive(arr, sum - arr[n - 1], n - 1) + recursive(arr, sum, n - 1);
        } else {
            return recursive(arr, sum, n - 1);
        }

    }
}
