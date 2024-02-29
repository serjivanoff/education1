package com.education.algos.leetcode;

import java.util.Arrays;

public class ShuffleArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ShuffleArray().shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }

    public int[] shuffle(int[] nums, int n) {
        if (n == 1) return nums;
        int[] res = new int[2 * n];
        for (int i = 0, j = 0; i < nums.length; i++, j++) {
            res[i++] = nums[j];
            res[i] = nums[j + n];
        }
        return res;
    }
}
