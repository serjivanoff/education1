package com.education.algos.leetcode.dynamic;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(3));
    }

    public int climbStairs(int n) {
        int[] k = new int[n + 1];
        k[0] = 1;
        k[1] = 1;
        for (int i = 2; i <= n; i++) {
            k[i] = k[i-1] + k[i-2];
        }
        return k[n];
    }
}
