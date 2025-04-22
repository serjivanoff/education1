package com.education.algos.leetcode;

import java.util.Arrays;
import java.util.List;

public class PrefixSumEasy {
    public static void main(String[] args) {
        var inst = new PrefixSumEasy();
//        System.out.println(Arrays.toString(inst.leftRightDifference(new int[]{1})));
//        System.out.println(inst.pivotInteger(4));
//        System.out.println(inst.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
//        System.out.println(inst.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
//        System.out.println(Arrays.toString(inst.answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})));
//        System.out.println(Arrays.toString(inst.answerQueries(new int[]{2, 3, 4, 5}, new int[]{1})));
        System.out.println(inst.findMiddleIndex(new int[]{2, 3, -1, 8, 4}));
        System.out.println(inst.findMiddleIndex(new int[]{1, -1, 4}));
    }

    //1991
    public int findMiddleIndex(int[] nums) {
        int length = nums.length;
        int[] prefSums = new int[length], sufSums = new int[length];
        for (int i = 0; i < length - 1; i++) {
            prefSums[i + 1] = prefSums[i] + nums[i];
            int back = length - i - 1;
            sufSums[back - 1] = sufSums[back] + nums[back];
        }
        for (int i = 0; i < length; i++) {
            if (prefSums[i] == sufSums[i]) return i;
        }
        return -1;
    }

    //2389
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        int[] res = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int q = queries[j];
            int i = 0;
            while (i < sums.length && sums[i] <= q) i++;
            res[j] = i;
        }
        return res;
    }

    //    2848
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] hashes = new int[101];
        for (List<Integer> car : nums) {
            for (int i = car.get(0); i < car.get(1); i++) {
                hashes[i] = 1;
            }
        }
        int res = 0;
        for (int h : hashes) res += h;
        return res;
    }

    //1588
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int qty = (length - i) * (i + 1);
            res += arr[i] * (qty / 2 + (qty % 2));
        }
        return res;
    }

    //2485
    public int pivotInteger(int n) {
        if (n == 1) return 1;
        int l = 1, r = n * (1 + n) / 2;
        for (int i = 2; i < n; i++) {
            l += i;
            r -= i - 1;
            if (l == r) return i;
        }
        return -1;
    }

    //2574
    public int[] leftRightDifference(int[] nums) {
        if (nums.length == 1) return new int[]{0};
        int[] res = new int[nums.length];
        int sum = 0;
        for (int n : nums) sum += n;
        int l = 0, r = sum;
        for (int i = 0; i < nums.length; i++) {
            r -= nums[i];
            int next = Math.abs(l - r);
            res[i] = next;
            l += nums[i];
        }
        return res;
    }
}
