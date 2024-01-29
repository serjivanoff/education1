package com.education.algos.leetcode;

public class NumberGoodPairs {
    public static void main(String[] args) {
        NumberGoodPairs numberGoodPairs = new NumberGoodPairs();
        System.out.println(numberGoodPairs.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(numberGoodPairs.numIdenticalPairs(new int[]{1, 1, 1, 1}));
    }

    public int numIdenticalPairs(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] == nums[1] ? 1 : 0;
        int[] hashes = new int[100];
        for (int num : nums) hashes[num - 1]++;
        int result = 0;
        for (int h : hashes)
            if (h != 0) result += ((h - 1) * h) / 2;
        return result;
    }
}
