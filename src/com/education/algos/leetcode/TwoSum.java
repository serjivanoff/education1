package com.education.algos.leetcode;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 2, 3}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        final int length = nums.length;
        if (length == 2) {
            return new int[]{0, 1};
        }
        int[] copyOf = Arrays.copyOf(nums, length);
        Arrays.sort(nums);
        for (int l = 0, r = length - 1; l < r; ) {
            final int left = nums[l], right = nums[r];
            final int sum = left + right;
            if (sum == target)
                return findIndexes(left, right, copyOf);
            if (sum < target) l++;
            else r--;
        }
        throw new IllegalArgumentException();
    }

    private int[] findIndexes(int left, int right, int[] nums) {
        final int [] indexes = new int[] {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == left && indexes[0] == -1) {
                indexes[0] = i;
                continue;
            }
            if (nums[i] == right && indexes[1] == -1) {
                indexes[1] = i;
            }
            if (indexes[0] != -1 && indexes[1] != -1) break;
        }
        return indexes;
    }
}
