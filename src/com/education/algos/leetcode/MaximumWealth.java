package com.education.algos.leetcode;

public class MaximumWealth {
    public static void main(String[] args) {
        System.out.println(new MaximumWealth().maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 56}}));
    }

    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int[] a : accounts) {
            int sum = 0;
            for (int j = 0; j < a.length; j++) {
                sum += a[j];
            }
            if (res < sum) res = sum;
        }
        return res;
    }
}
