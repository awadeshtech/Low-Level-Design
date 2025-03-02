package com.lld.designproject.dynamic_programming.knapsack_unbounded_pattern;

public class UnboundedKnapsackRecursive {
    public static void main(String[] args) {
        int[] weight = new int[] {1, 3, 4, 5};
        int[] val = new int[] {7, 4, 5, 7};
        int W = 7;
        System.out.println(unboundedKnapsackRecursive(weight, val, W, 4));
    }

    private static int unboundedKnapsackRecursive(int[] weight, int[] val, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (weight[n - 1] <= W) {
            return Math.max(val[n - 1] + unboundedKnapsackRecursive(weight, val, W - weight[n - 1], n),
                unboundedKnapsackRecursive(weight, val, W, n - 1));
        } else {
            return unboundedKnapsackRecursive(weight, val, W, n - 1);
        }
    }
}
