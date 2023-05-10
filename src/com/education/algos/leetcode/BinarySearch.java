package com.education.algos.leetcode;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{-3, 2, 4, 6, 8, 9, 10, 14, 15, 19};
        int i = new BinarySearch().search(array, 11);
        System.out.println(i);
    }

    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) return -1;
        int l = 0, r = nums.length, idx = (r + l) / 2, cur = nums[idx];
        while (cur != target && l < idx && r > idx) {
            if (cur > target) {
                r = idx;
            } else {
                l = idx;
            }
            idx = (r + l) / 2;
            cur = nums[idx];
        }
        return cur == target ? idx : -1;
    }
}
