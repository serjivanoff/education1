package com.education.algos.leetcode;

public class SumOfUnique {
    public static void main(String[] args) {
        System.out.println(new SumOfUnique().sumOfUnique(new int[]{1, 2, 3, 2}));
        System.out.println(new SumOfUnique().sumOfUnique(new int[]{1, 2, 3, 4, 5}));
    }

    public int sumOfUnique(int[] nums) {
        int[] hashes = new int[101];
        for (int i : nums) {
            hashes[i]++;
        }
        int res = 0;
        for (int i = 0; i < hashes.length; i++) {
            if (hashes[i] == 1) res += i;
        }
        return res;
    }
}
