package com.education.algos.leetcode;

public class CountConsistentStrings {

    public static void main(String[] args) {
        System.out.println(new CountConsistentStrings().countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));
    }

    public int countConsistentStrings(String allowed, String[] words) {
        char[] aChars = allowed.toCharArray();
        char[] hashed = new char[128];
        for (char c : aChars) hashed[c] = 1;
        int res = 0;
        for (String s : words) {
            char[] sChars = s.toCharArray();
            boolean f = true;
            for (char c : sChars) {
                if (hashed[c] != 1) {
                    f = false;
                    break;
                }
            }
            if (f) res++;
        }
        return res;
    }
}
