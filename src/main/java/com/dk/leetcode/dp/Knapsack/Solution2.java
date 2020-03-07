package com.dk.leetcode.dp.Knapsack;

/// 背包问题
/// 动态规划
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(n * C)
public class Solution2 {

    public int knapsack01(int[] weight, int[] value, int capacity) {
        if (weight == null || value == null || weight.length != value.length)
            throw new IllegalArgumentException("Invalid weight or value");

        if (capacity < 0)
            throw new IllegalArgumentException("capacity must be greater than or equal to zero.");

        int n = weight.length;
        if (n == 0 || capacity == 0)
            return 0;

        int[][] memo = new int[n][capacity + 1];
        
        for (int j = 0; j <= capacity; j++) {
            memo[0][j] = (j >= weight[0] ? value[0] : 0);
        }

        for (int i = 1; i < n ; i++) {
            for (int j = 0; j<= capacity ; j++) {
                memo[i][j] = memo[i-1][j];
                if (j >= weight[i]) {
                    memo[i][j] = Math.max( memo[i][j], value[i] + memo[i-1][j-weight[i]]);
                }
            }
        }

        return memo[n-1][capacity];
    }
}
