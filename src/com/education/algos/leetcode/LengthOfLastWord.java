package com.education.algos.leetcode;

public class LengthOfLastWord {
    public static void main(String[] args) {
//        final String s = "luffy is still joyboy";
//        final String s = "hello world";
        final String s = "H";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
    }

    public int lengthOfLastWord(final String s) {
        final char[] chars = s.toCharArray();
        int r = 0, l = chars.length - 1;
        for (; l >= 0; l--) {
            if (chars[l] == 32) continue;
            r = l--;
            break;
        }
        while (l >= 0 && chars[l] != 32) l--;
        return r - l;
    }
}
