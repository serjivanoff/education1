package com.education.algos.leetcode;

public class IntPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }

    private static boolean isPalindrome(int x) {
        if (x == 0)
            return true;
        if (x < 0)
            return false;
        int LENGTH = 10;
        int[] digits = new int[LENGTH];
        int n = LENGTH;
        do {
            digits[--n] = x % 10;
        }
        while ((x = x / 10) > 0);
        for (int i = LENGTH - 1; i > (LENGTH + n) / 2; i--) {
            if (digits[i] != digits[LENGTH + n - i - 1])
                return false;
        }
        return true;
    }
}
