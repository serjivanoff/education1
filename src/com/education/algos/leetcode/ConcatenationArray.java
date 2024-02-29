package com.education.algos.leetcode;

import java.util.Arrays;

public class ConcatenationArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ConcatenationArray().getConcatenation(new int[]{1, 2, 1})));
    }

    public int[] getConcatenation(int[] nums) {
        int l = nums.length;
        int[] res = new int[l * 2];
        for (int i = 0; i < l; i++) {
            res[i] = nums[i];
            res[i + l] = nums[i];
        }
        return res;
    }
}
