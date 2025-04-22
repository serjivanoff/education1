package com.education.algos.leetcode;

public class LengthLastWord {
    public static void main(String[] args) {
        System.out.println(new LengthLastWord().lengthOfLastWord("   fly me   to   the moon  "));
    }
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int res = 0, start = chars.length - 1;
        while (chars[start] == ' ') start--;
        for (int i = start; i >= 0; i--) {
            if (chars[i] == ' ') break;
            res++;
        }
        return res;
    }
}
