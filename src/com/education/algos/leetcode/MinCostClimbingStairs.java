package com.education.algos.leetcode;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{0, 2, 2, 1}));
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{2, 2, 0, 1}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = cost[0];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i - 1];
        }
        return Math.min(dp[cost.length], dp[cost.length - 1]);
    }

}
