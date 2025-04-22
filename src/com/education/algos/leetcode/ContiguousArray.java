package com.education.algos.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public static void main(String[] args) {
        System.out.println(new ContiguousArray().findMaxLength(new int[]{0, 1, 1}));
        System.out.println(new ContiguousArray().findMaxLength(new int[]{0, 1, 0}));
        System.out.println(new ContiguousArray().findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
        System.out.println(new ContiguousArray().findMaxLength(new int[]{1,1,1,1,1,1,1,0,0,0,0,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,1,1,0,0,0,0,1,0,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,1,0,0,1,1,0,1,0,0,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1}));
    }

    public int findMaxLength(int[] nums) {
        int length = nums.length;
        int[] sums = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) sum++;
            else sum--;
            sums[i] = sum;
        }
        if (Math.abs(sums[length - 1]) == length) return 0;
        if (sums[length - 1] == 0) return length;
        Map<Integer, Integer> map = new HashMap<>(512);
        int res = 0;
        for (int i = 0; i < length; i++) {
            int index = sums[i];
            if (index == 0 && res < i + 1)  {
                res = i + 1;
                continue;
            }
            Integer exist = map.get(index);
            if (exist == null) {
                map.put(index, i);
            }  else {
                int d = Math.abs(i - exist);
                if (res < d) res = d;
            }
        }
        return res;
    }
}
