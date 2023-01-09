package com.education.leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"floor", "fl", "flora"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        char[][] chars = new char[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            chars[i] = strs[i].toCharArray();
        }
        char[] result = new char[200];
        int j = 0;
        while (true) {
            if (chars[0].length == j) {
                return new String(result, 0, j);
            }
            char c = chars[0][j];
            for (int i = 1; i < strs.length; i++) {
                if (chars[i].length == j || chars[i][j] != c) {
                    return new String(result, 0, j);
                }
            }
            result[j++] = c;
        }
    }
}
