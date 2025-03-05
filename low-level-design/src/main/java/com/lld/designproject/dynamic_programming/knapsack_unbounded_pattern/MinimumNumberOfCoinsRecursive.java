package com.lld.designproject.dynamic_programming.knapsack_unbounded_pattern;

public class MinimumNumberOfCoinsRecursive {
    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 5};
        int amount = 11;
        int size = coins.length;
        System.out.println(recursive(coins, amount, size));
    }

    private static int recursive(int[] coins, int amount, int size) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0 || size <= 0) {
            return Integer.MAX_VALUE - 1;
        }

        if (coins[size - 1] <= amount) {
            return Math.min(1 + recursive(coins, amount - coins[size - 1], size), recursive(coins, amount, size - 1));
        } else {
            return recursive(coins, amount, size - 1);
        }
    }
}
