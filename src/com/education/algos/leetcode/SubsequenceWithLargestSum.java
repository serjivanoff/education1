package com.education.algos.leetcode;

import java.util.*;

public class SubsequenceWithLargestSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SubsequenceWithLargestSum().maxSubsequence(new int[] {18,3,19,-8,30,22,-35,11,16,18,-21,32,-7,-6,38,25,-21,-1,26,-8,-37,-39,-34,6,-36,-3,26,-32,22,-20,35,-35,-30,-8,11,7,-23,-9,-22,1,33,-6,12,2,27,-27,28,-12,21,12,16,21,33}, 50)));
    }

    public int[] maxSubsequence(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            List<Integer> list = map.computeIfAbsent(n, k1 -> new ArrayList<>());
            list.add(i);
        }
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int count = 0;
        int[] indexes = new int[k];
        for (int i = copy.length - 1; i >= 0; i--) {
            List<Integer> bucket = map.remove(copy[i]);
            if (bucket != null) {
               int j = 0;
               while (j < bucket.size() && count < k) {
                   indexes[count++] = bucket.get(j++);
               }
               if (count == k) break;
            }
        }
        int [] res = new int[k];
        Arrays.sort(indexes);
        for (int i = 0; i < k; i++) {
            res[i] = nums[indexes[i]];
        }
        return res;
    }

}
