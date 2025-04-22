package com.education.algos.leetcode.dynamic;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new HouseRobber().rob(new int[]{2,7,9,3,1}));
    }

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[length - 1];
    }
}
