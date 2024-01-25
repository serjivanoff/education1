package com.education.algos.leetcode;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(new FibonacciNumber().fib(30));
    }

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int prev = 1, bPrev = 1, cur = 0;
        for (int i = 3; i <= n; i++) {
            int tmp = prev;
            cur = prev + bPrev;
            prev = cur;
            bPrev = tmp;
        }
        return cur;
    }
}
