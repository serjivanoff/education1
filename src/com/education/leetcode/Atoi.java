package com.education.leetcode;

public class Atoi {

    public static void main(String[] args) {
        System.out.println(new Atoi().myAtoi("2147483646"));
    }

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        int i = 0;
        while (i < chars.length && chars[i] == 32) i++;
        if (i == chars.length) return 0;
        boolean negative = chars[i] == 45;
        if (negative || chars[i] == 43) i++;
        while (i < chars.length && chars[i] == 48) i++;
        if (i == chars.length) return 0;
        int j = i;
        while (j < chars.length && (chars[j] >= 48 && chars[j] <= 57)) j++;
        if (j == i) return 0;
        int dec = 1, result = 0;
        while (--j >= i) {
            final int c = chars[j] - 48;
            if (c > 2 && dec == 1000_000_000) return getMaxOrMin(negative);
            int next = c * dec + result;
            if (next < result) return getMaxOrMin(negative);
            result = next;
            if (j > i && dec == 1000_000_000) return getMaxOrMin(negative);
            dec *= 10;
        }
        return negative ? -result : result;
    }

    private int getMaxOrMin(final boolean negative) {
        return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }
}
