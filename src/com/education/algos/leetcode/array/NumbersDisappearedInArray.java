package com.education.algos.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class NumbersDisappearedInArray {
    public static void main(String[] args) {
//        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums = {1, 1};
        findDisappearedNumbers(nums);
        System.out.println();
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a == -1) continue;
            doThing(nums, a - 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) res.add(i + 1);
        }
        return res;
    }

    private static void doThing(int[] nums, int i) {
        while (nums[i] != -1) {
            int a  = nums[i] - 1;
            nums[i] = -1;
            i = a;
        }
    }
}
