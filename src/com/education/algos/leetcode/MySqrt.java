package com.education.algos.leetcode;

public class MySqrt {
    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(2147395599));
        System.out.println(new MySqrt().mySqrt(2147483647));
        System.out.println(new MySqrt().mySqrt(145));
        System.out.println(new MySqrt().mySqrt(143));
    }

    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int res = 23170, l = 1, r = 46340;
        do {
            int a = res * res;
            if (a == x) return res;
            if (a > x) {
                r = res;
                res = res - ((res - l) >> 1);
            } else {
                l = res;
                int d = r - res;
                res += d > 1 ? d >> 1 : d;
            }
        } while (r - l > 1);
        return res * res > x ? res - 1 : res;
    }
}
