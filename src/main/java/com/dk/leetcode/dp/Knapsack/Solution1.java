package com.dk.leetcode.dp.Knapsack;

/// 背包问题
/// 记忆化搜索
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(n * C)
public class Solution1 {
    private int[][] memo;

    public int knapsack01(int[] weight, int[] value, int capacity) {
        if (weight == null || value == null || weight.length != value.length)
            throw new IllegalArgumentException("Invalid weight or value");

        if (capacity < 0)
            throw new IllegalArgumentException("capacity must be greater than or equal to zero.");

        int n = weight.length;
        if (n == 0 || capacity == 0)
            return 0;

        memo = new int[n][capacity + 1];
        return bestValue(weight, value, n-1, capacity);
    }

    // 用 [0...index]的物品,填充容积为capacity的背包的最大价值
    private int bestValue(int[] weight, int[] value, int index, int capacity) {
        if (capacity <= 0 || index < 0)
            return 0;

        if (memo[index][capacity] != -1)
            return memo[index][capacity];

        int res = bestValue(weight, value, index-1, capacity);
        if (capacity >= weight[index]) {
            res = Math.max(res, value[index] + bestValue(weight, value, index - 1, capacity - weight[index]));
            memo[index][capacity] = res;
        }

        return res;
    }

}
