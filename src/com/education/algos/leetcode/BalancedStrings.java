package com.education.algos.leetcode;

public class BalancedStrings {
    public static void main(String[] args) {
        System.out.println(new BalancedStrings().balancedStringSplit("RLRRLLRLRL"));
    }

    public int balancedStringSplit(String s) {
        if (s.length() == 2) return 1;
        int r = 0, l = 0, result = 0;
        char[] chars = s.toCharArray();
        for (char c: chars) {
            if (c == 'R') r++; else l++;
            if (r == l) {
                result++;
                r = 0; l = 0;
            }
        }
        return result;
    }
}
