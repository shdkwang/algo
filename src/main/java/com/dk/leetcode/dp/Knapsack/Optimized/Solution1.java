package com.dk.leetcode.dp.Knapsack.Optimized;

/// 背包问题
/// 动态规划改进: 滚动数组
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(C), 实际使用了2*C的额外空间
public class Solution1 {
    public int knapsack01(int[] weight, int[] value, int capacity) {
        if (weight == null || value == null || weight.length != value.length)
            throw new IllegalArgumentException("Invalid weight or value");

        if (capacity < 0)
            throw new IllegalArgumentException("capacity must be greater than or equal to zero.");

        int n = weight.length;
        if (n == 0 || capacity == 0)
            return 0;

        int[][] memo = new int[2][capacity + 1];

        for (int j = 0; j <= capacity; j++) {
            memo[0][j] = ( j >= weight[0] ? value[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j<= capacity; j++) {
                memo[i%2][j] = memo[(i-1)%2][j];
                if (j >= weight[i]) {
                    memo[i%2][j] = Math.max(memo[i%2][j], value[i] + memo[(i-1)%2][j - weight[i]]);
                }
            }
        }

        return memo[(n-1)%2][capacity];
    }

    public static void main(String[] args) {
        int[] weight = new int[]{1, 2, 3};
        int[] value = new int[]{6, 10, 12};
        int capacity = 5;
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.knapsack01(weight, value, capacity));
    }
}
