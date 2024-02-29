package com.education.algos.leetcode;

import java.util.Arrays;

public class BuildArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BuildArray().buildArray(new int[]{0, 2, 1, 5, 3, 4})));
    }

    public int[] buildArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int next = nums[nums[i]];
            if (next > 1000) next = next % 1001;
            nums[i] = nums[i] % 1001 + next * 1001;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] / 1001;
        }
        return nums;
    }
}
