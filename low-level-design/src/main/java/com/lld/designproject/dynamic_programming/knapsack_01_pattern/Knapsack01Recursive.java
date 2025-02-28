package com.lld.designproject.dynamic_programming.knapsack_01_pattern;

public class Knapsack01Recursive {
    public static void main(String[] args) {
        int[] weight = new int[] {1, 3, 4, 5};
        int[] val = new int[] {1, 4, 5, 7};
        int W = 7;
        int n = 4;
        System.out.println(knapsack01Recursive(weight, val, W, n));
    }

    private static int knapsack01Recursive(int[] weight, int[] val, int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (weight[n - 1] <= W) {
            return Math.max(val[n - 1] + knapsack01Recursive(weight, val, W - weight[n - 1], n - 1),
                knapsack01Recursive(weight, val, W, n - 1));
        } else {
            return knapsack01Recursive(weight, val, W, n - 1);
        }
    }
}
