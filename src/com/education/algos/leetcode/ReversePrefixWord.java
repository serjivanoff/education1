package com.education.algos.leetcode;

public class ReversePrefixWord {
    public static void main(String[] args) {
        System.out.println(new ReversePrefixWord().reversePrefix("xyxzxe", 'd'));
        System.out.println(new ReversePrefixWord().reversePrefix("abcdefd", 'd'));
    }

    public String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch) {
                int distance = i / 2;
                for (int j = i; j > distance; j--) {
                    char c = chars[j];
                    chars[j] = chars[i - j];
                    chars[i - j] = c;
                }
                return new String(chars);
            }
        }
        return word;
    }
}
