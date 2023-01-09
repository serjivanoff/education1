package com.education.leetcode;

public class LongestPalindromeManacher {

    public static void main(String[] args) {
        String s = "aa1aa";
        System.out.println(new LongestPalindromeManacher().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        char[] chars;
        if (s.length() % 2 == 0) {
            chars = new char[s.length() + 1];
            System.arraycopy(s.toCharArray(), 0, chars, 0, s.length());
             chars[s.length()] = '#';
        } else {
              chars = s.toCharArray();
        }
        final int L = chars.length;
        int max = 0, begin = 0, end = 0;
        for (int i = 1; i < L - 1; i++) {
            int l = i - 1, r = i + 1;
            final char c = chars[i];
            char left = chars[l], right = chars[r];
//            oo
            if (c == left) {
                r = i;
                while (l >= 0 && r < L) {
                    if (chars[l] != chars[r]) break;
                    l--; r++;
                }
                if (--r - ++l > max) {
                    max = r - l;
                    begin = l; end = r;
                }
            }
            r = i + 1;
            if (c == right) {
                l = i;
                while (l >= 0 && r < L) {
                    if (chars[l] != chars[r]) break;
                    l--; r++;
                }
                if (--r - ++l > max) {
                    max = r - l;
                    begin = l; end = r;
                }
            }
//            oio
            l = i - 1; r = i + 1;
            if (left == right) {
                while (l >= 0 && r < L) {
                    if (chars[l] != chars[r]) break;
                    l--; r++;
                }
                if (--r - ++l > max) {
                    max = r - l;
                    begin = l; end = r;
                }
            }
        }
        char[] result = new char[1 + end - begin];
        System.arraycopy(chars, begin, result, 0, result.length);
        return new String(result);
    }

}