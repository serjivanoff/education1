package com.education.algos.leetcode;

public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement quiz = new RemoveElement();
        int[] array = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        quiz.removeElement(array, 2);
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != val)
                nums[j++] = nums[i];
            i++;
        }
        return j;
    }
}
