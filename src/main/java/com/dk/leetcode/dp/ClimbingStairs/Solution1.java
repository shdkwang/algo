package com.dk.leetcode.dp.ClimbingStairs;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liuyubobobo.
 */
public class Solution1 {

    private int[] memo;

    public int climbStairs(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return calcWays(n);
    }

    private int calcWays(int n){

        if(n == 0 || n == 1)
            return 1;

        if(memo[n] == -1)
            memo[n] = calcWays(n - 1) + calcWays(n - 2);

        return memo[n];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = null;
        int row = triangle.size();
        Integer[][] memo = new Integer[row][row];
        for(int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i==0 && j==0) {
                    continue;
                }  else if (j==0) {
                    memo[i][j] = triangle.get(i-1).get(j);
                } else if (j==i) {
                    memo[i][j] = triangle.get(i-1).get(j-1);
                } else {
                    memo[i][j] = triangle.get(i-1).get(j) <= triangle.get(i-1).get(j-1) ? triangle.get(i-1).get(j) : triangle.get(i-1).get(j-1);
                }
            }
        }
        
        System.out.println((new Solution1()).climbStairs(10));
    }
}
