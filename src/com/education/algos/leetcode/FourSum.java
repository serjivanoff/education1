package com.education.algos.leetcode;

import java.util.*;

public class FourSum {

    public static void main(String[] args) {
//        int[] a = new int[]{-15, -13, -12, 2, 3, 4, 5, 5, 6, 7, 8, 10};
//        int[] a = new int[]{2, 2, 2, 2, 2};
//        int[] a = new int[]{-3,-2,-1,0,0,1,2,3};
//        int[] a = new int[]{-4, -3, -2, -1, 0, 0, 1, 2, 3, 4};
//        int[] a = new int[]{0, -1, -3, 5, -5};
        int[] a = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        var quiz = new FourSum();
        List<List<Integer>> lists = quiz.fourSum(a, -294967296);
    }

    private void addFour(List<List<Integer>> set, int num, int num1, int num2, int num3) {
        List<Integer> l = new ArrayList<>(4);
        l.add(num);
        l.add(num1);
        l.add(num2);
        l.add(num3);
        set.add(l);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        if (nums.length == 4) {
            int s = 0;
            for (int i = 0; i < nums.length; i++) {
                int old = s;
                s += nums[i];
                if (s < old && i > 0 && nums[i] >= nums[i - 1]) return Collections.emptyList();
            }
            if (s == target) {
                List<Integer> list = new ArrayList<>();
                for (int num : nums) list.add(num);
                result.add(list);
            }
            return result;
        }
        Arrays.sort(nums);
        if(nums[0] > 0 && target < 0) return result;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int s = nums[i] + nums[j];
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int s1 = s + nums[l] + nums[r];
                    if (target == s1) {
                        addFour(result, nums[i], nums[j], nums[l], nums[r]);
                        while (l < r && nums[r] == nums[r - 1]) --r;
                        while (l < r && nums[l] == nums[l + 1]) ++l;
                        l++;
                        continue;
                    }
                    if (s1 < target) l++;
                    else r--;
                }
                while (j < nums.length - 2 && nums[j] == nums[j + 1]) j++;
            }
            while (i < nums.length - 3 && nums[i] == nums[i + 1]) i++;
        }
        return result;
    }
}
