package com.education.leetcode;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        final ThreeSum threeSum = new ThreeSum();
//        List<List<Integer>> sum = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4});
//        List<List<Integer>> sum = threeSum.threeSum(new int[]{-2, 0, 0, 2, 2});
        List<List<Integer>> sum = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i], l = i + 1, r = nums.length - 1;
            while (l < r) {
                int s = a + nums[l] + nums[r];
                if (s == 0) {
                    result.add(List.of(a, nums[l++], nums[r--]));
                    while (l < r && nums[l - 1] == nums[l]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (s < 0) l++;
                else r--;
            }
        }
        return result;
    }
}
