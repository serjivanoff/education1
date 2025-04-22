package com.education.algos.leetcode;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(16));
    }

    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int one = num/2;
        if (one == 0 || one == 1) {
            return false;
        }
        int two = num / one;
        while (two != one) {
            one = (one + two) / 2;
            two = num / one;
            int d = two - one;
            if (d == 1 || d == -1) return false;
        }
        return two * one == num;
    }
}
