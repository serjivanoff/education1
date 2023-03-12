package com.education.algos.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    public static void main(String[] args) {
        List<String> strings = new LetterCombinations().letterCombinations("257");
        System.out.println(0 % 3);
    }

    private static final char[][] mapping = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();
        char[] chars = digits.toCharArray();
        char[][] localMapping = new char[chars.length][];
        int n = 1;
        for (int i = 0; i < chars.length; i++) {
            localMapping[i] = mapping[chars[i] - 50];
            n *= localMapping[i].length;
        }
        List<String> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            result.add(getFromDigit(chars.length, i, localMapping));
        }
        return result;
    }

    private String getFromDigit(int length, int digit, char[][] mappings) {
        char[] word = new char[length];
        for (int i = 0; i < length; i++) {
            char[] chars = mappings[i];
            boolean isThree = chars.length == 3;
            word[i] = chars[digit % (isThree ? 3 : 4)];
            digit = digit / (isThree ? 3 : 4);
        }
        return new String(word);
    }
}
