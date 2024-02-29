package com.education.algos.leetcode;

import java.util.Arrays;

public class FindIntersectionValues {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindIntersectionValues().findIntersectionValues(new int[]{3, 4, 2, 3}, new int[]{1, 5})));
        //exp [4, 2]
        System.out.println(Arrays.toString(new FindIntersectionValues().findIntersectionValues(new int[]{24, 28, 7, 27, 7, 27, 9, 24, 9, 10}, new int[]{12, 29, 9, 7, 5})));
    }

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] hashed1 = new int[101], hashed2 = new int[101];
        for (int i = 0; i < nums1.length; i++) {
            hashed1[nums1[i]] = 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            hashed2[nums2[i]] = 1;
        }
        int first = checkIntersection(hashed2, nums1);
        int second = checkIntersection(hashed1, nums2);
        return new int[]{first, second};
    }

    private int checkIntersection(int[] hashed, int[] nums) {
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) if (hashed[nums[i]] != 0) res++;
        return res;
    }
}
