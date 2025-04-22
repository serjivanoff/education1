package com.education.algos.leetcode;

public class MaxSumAfterPartitioning {
    public static void main(String[] args) {

    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int iMax = getMax(arr, 0, k), max = arr[iMax];
        int[] maxes = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            maxes[i] = max;

        }
        return 0;
    }

    private int getMax(int[] arr, int start, int k) {
        int iMax = start, max = arr[iMax];
        for (int i = start + 1; i < start + k && i < arr.length; i++) {
            if (max < arr[i]) {
                iMax = 1; max = arr[i];
            }
        }
     return iMax;
    }
}
