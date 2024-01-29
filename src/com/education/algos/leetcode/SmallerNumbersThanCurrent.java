package com.education.algos.leetcode;

import java.util.Arrays;

public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        SmallerNumbersThanCurrent inst = new SmallerNumbersThanCurrent();
        System.out.println(Arrays.toString(inst.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
//        System.out.println(Arrays.toString(inst.smallerNumbersThanCurrent(new int[]{5, 0, 10, 0, 10, 6})));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) if (max < nums[i]) max = nums[i];
        int[] hashes = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            hashes[nums[i]]++;
        }
        for (int i = 1; i < hashes.length; i++) {
            hashes[i] += hashes[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] == 0 ? 0 : hashes[nums[i] - 1];
        }
        return result;
    }
}
