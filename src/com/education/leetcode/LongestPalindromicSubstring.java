package com.education.leetcode;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(s));
    }

    private boolean isPalindrome(char[] chars) {
        int L = chars.length;
        for (int i = 0; i < L / 2; i++) {
            if (chars[i] != chars[L - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        if(s.length() == 1 || isPalindrome(s.toCharArray())) {
            return s;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        char[] result = {};
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                int curLength = j - i;
                char[] current = new char[curLength];
                System.arraycopy(chars, i, current, 0, curLength);
                if (isPalindrome(current)) {
                    if (result.length < curLength) {
                        result = current;
                    }
                }
            }
        }
        return new String(result);
    }
}
