package com.education.leetcode;

public class Maximum69Number {

    public static void main(String[] args) {
        System.out.println(new Maximum69Number().maximum69Number(9669));
    }

    public int maximum69Number(int num) {
        int n = num, dec = 100_000_000, quote = 0;
        while (dec != 0 && (quote = num / dec) != 6) {
            if (quote != 0)
                num -= dec * 9;
            dec /= 10;
        }
        return n + 3 * dec;
    }
}
