package com.education.algos.leetcode;

public class FirstOccurrenceString {

    public static void main(String[] args) {
//        String haystack = "ssadbutsad", needle = "sad";
        String haystack = "mississippi", needle = "issipi";
        FirstOccurrenceString quiz = new FirstOccurrenceString();
        int i = quiz.strStr(haystack, needle);
    }

    public int strStr(String haystack, String needle) {
        char[] haystackC = haystack.toCharArray();
        char[] needleC = needle.toCharArray();
        if (needleC.length <= haystackC.length) {
            for (int i = 0; i < haystackC.length; i++){
                int j = 0;
                int index = i;
                while (j < needleC.length && i < haystackC.length && haystackC[i] == needleC[j]) {
                    j++; i++;
                }
                if (j == needleC.length) return index;
                if (j != 0) i = index;
            }
        }
        return -1;
    }
}
