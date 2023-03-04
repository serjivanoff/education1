package com.education.algos.leetcode;

import java.util.Arrays;

public class IntegerToRoman {

    private final static char[][] digits = new char[][]{
            {},
            {'I'},
            {'I', 'I'},
            {'I', 'I', 'I'},
            {'I', 'V'},
            {'V'},
            {'V', 'I'},
            {'V', 'I', 'I'},
            {'V', 'I', 'I', 'I'},
            {'I', 'X'},
            {'X'},
    };
    private final static char[][] decimals = new char[][]{
            {},
            {'X'},
            {'X', 'X'},
            {'X', 'X', 'X'},
            {'X', 'L'},
            {'L'},
            {'L', 'X'},
            {'L', 'X', 'X'},
            {'L', 'X', 'X', 'X'},
            {'X', 'C'},
            {'C'},
    };

    private final static char[][] hundreds = new char[][]{
            {},
            {'C'},
            {'C', 'C'},
            {'C', 'C', 'C'},
            {'D', 'C'},
            {'D'},
            {'D', 'C'},
            {'D', 'C', 'C'},
            {'D', 'C', 'C', 'C'},
            {'C', 'M'},
            {'M'},
    };

    public static void main(String[] args) {
        IntegerToRoman runner = new IntegerToRoman();
        System.out.println(runner.intToRoman(1908));
    }

    public String intToRoman(int num) {
        int dec = 1000, index = 0;
        char[] chars = new char[15];
        while (dec != 0) {
            int rem = num / dec;
            char[] nextDigits = getRomanDigits(rem, dec);
            System.arraycopy(nextDigits, 0, chars, index, nextDigits.length);
            index += nextDigits.length;
            num -= dec * rem;
            dec /= 10;
        }
        return new String(Arrays.copyOf(chars, index));
    }

    private char[] getRomanDigits(int digit, int dec) {
        switch (dec) {
            case 1000: {
                char[] result = new char[digit];
                for (int i = 0; i < digit; i++) {
                    result[i] = 'M';
                }
                return result;
            }
            case 100:
                return hundreds[digit];
            case 10:
                return decimals[digit];
            case 1:
                return digits[digit];
            default:
                throw new IllegalArgumentException("Provided number violates constrains");
        }
    }
}
