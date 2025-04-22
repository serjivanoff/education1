package com.education.algos.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayEasyTier {
    public static void main(String[] args) {
        ArrayEasyTier arrayEasyTier = new ArrayEasyTier();
        System.out.println(arrayEasyTier.countPairs(Arrays.asList(-1,1,2,3,1), 2));
    }

    public int countPairs(List<Integer> nums, int target) {
        nums.sort(Comparator.naturalOrder());
        int res = 0, l = 0, left = nums.get(l);
        for (int i = nums.size() - 1; i > l; i--) {
            if (nums.get(i) + left < target) {
                res += i++ - l;
                left = nums.get(++l);
            }
        }
        return res;
    }
}
