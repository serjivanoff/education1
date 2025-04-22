package com.education.algos.leetcode;

public class ReverseWordsInString {
    public static void main(String[] args) {
//        System.out.println(new ReverseWordsInString().reverseWords(" th     e sky is    blue     "));
        System.out.println(new ReverseWordsInString().reverseWords("  hello world  "));
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = chars.length - 1, end = 0;
        while (start >= 0 && chars[start] == ' ') start--;
        while (end < start && chars[end] == ' ') end++;
        StringBuilder sb = new StringBuilder(chars.length);
        for (int i = start; i >= end; i--) {
            if (chars[i] == ' ') {
                int wl = start - i;
                char[] word = new char[wl + 1];
                System.arraycopy(chars, i + 1, word, 0, wl);
                word[wl] = ' ';
                sb.append(word);
                while (i >= end && chars[i] == ' ') i--;
                start = i;
            }
        }
        char[] word = new char[start - end + 1];
        System.arraycopy(chars, end, word, 0, word.length);
        sb.append(word);
        return sb.toString();
    }
}
