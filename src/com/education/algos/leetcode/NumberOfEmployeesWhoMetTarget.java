package com.education.algos.leetcode;

public class NumberOfEmployeesWhoMetTarget {
    public static void main(String[] args) {
        System.out.println(new NumberOfEmployeesWhoMetTarget().numberOfEmployeesWhoMetTarget(new int[]{0, 1, 2, 3, 4}, 3));
    }

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int res = 0;
        for (int h : hours) {
            if (h >= target) res++;
        }
        return res;
    }
}
