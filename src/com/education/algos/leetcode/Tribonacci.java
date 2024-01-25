package com.education.algos.leetcode;

public class Tribonacci {
    public static void main(String[] args) {
        System.out.println(new Tribonacci().tribonacci(25));
    }

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int tN1 = 1, tN2 = 1, tN3 = 0, t = 0;
        for (int i = 3; i <= n; i++) {
            t = tN1 + tN2 + tN3;
            tN3 = tN2;
            tN2 = tN1;
            tN1 = t;
        }
        return t;
    }
}
