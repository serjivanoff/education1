package com.education.algos.leetcode;

public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition quiz = new SearchInsertPosition();
        System.out.println(quiz.searchInsert(new int[]{1,3,5,6}, 7));
    }

    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        int c = nums.length / 2, l = 0, r = nums.length - 1;
        while (r > l && nums[c] != target) {
            if (nums[c] < target) l = c + 1;
            else r = c - 1;
            c = (r + l) / 2;
        }
        if (nums[c] >= target) return c;
        return c + 1;
    }
}
