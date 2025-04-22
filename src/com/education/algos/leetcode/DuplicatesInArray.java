package com.education.algos.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesInArray {
    public static void main(String[] args) {
        System.out.println(new DuplicatesInArray().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        int[] hashes = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            hashes[nums[i]]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < hashes.length; i++) {
            if (hashes[i] == 2) res.add(i);
        }
        return res;
    }
}
