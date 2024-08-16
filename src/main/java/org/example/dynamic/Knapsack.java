package org.example.dynamic;

/*
Given a set of items, each with a weight and a value,
 determine which items to include in the collection so that
  the total weight is less than or equal to a given limit and
   the total value is as large as possible.
Time Complexity: O(n * W)
Space Complexity: O(n * W)
 */

class Knapsack {
    public int knapsack(int W, int[] weights, int[] values, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        int n = values.length;
        Knapsack ks = new Knapsack();
        System.out.println("Maximum value in Knapsack: " + ks.knapsack(W, weights, values, n));
    }
}
