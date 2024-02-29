package com.education.algos.leetcode;

public class PairsWithAbsoluteDifferenceK {

    public static void main(String[] args) {
        System.out.println(new PairsWithAbsoluteDifferenceK().countKDifference(new int[]{33,90,62,43,21,96,20,18,84,74,61,100,5,11,4,67,96,18,6,68,82,32,76,33,93,33,71,32,30,63,37,46,95,51,63,77,63,84,52,78,66,76,66,9,73,92,79,65,29,42}, 64));
    }

    public int countKDifference(int[] nums, int k) {
        int[] hashed = new int[101];
        for (int i = 0; i < nums.length; i++) {
            hashed[nums[i]]++;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = nums[i], r = l + k;
            if (r > 100) continue;
            if (hashed[r] != 0) result+= hashed[r];
        }
        return result;
    }
}
