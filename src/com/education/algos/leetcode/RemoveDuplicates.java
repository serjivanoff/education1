package com.education.algos.leetcode;

public class RemoveDuplicates {

    public static void main(String[] args) {
//        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{1, 2, 2, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5}));
        int[] ints = {0, 1, 1, 2, 3, 3, 4};
        int i = new RemoveDuplicates().removeDuplicates(ints);
        for (int k = 0; k < i; k++) {
            System.out.println(ints[k]);
        }
    }

    public int removeDuplicates(int[] nums) {
        int l = 0, r = 1;
        while (l < nums.length && r < nums.length) {
            while (r < nums.length && nums[l] == nums[r]) r++;
            if (r == nums.length) break;
            nums[++l] = nums[r++];
        }
        return ++l;
    }

}