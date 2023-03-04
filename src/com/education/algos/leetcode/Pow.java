package com.education.algos.leetcode;

public class Pow {
    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.myPow(2, Integer.MIN_VALUE));

    }

    public double myPow(double x, int n) {
        double P = 1;
        if (n == 0 || x == 1)
            return P;
        if (x == -1)
            return n % 2 == 0 ? 1 : -1;
        boolean minus = false;
        if (n < 0) {
            minus = true;
            n = -n;
            if (n < 0)
                return 0;
        }
        P = pow(x, n);
        return minus ? 1 / P : P;
    }

    public double pow(double x, int n) {
        if (n == 0)
            return 1;
        return n % 2 == 0 ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
    }
}
