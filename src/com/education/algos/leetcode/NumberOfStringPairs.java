package com.education.algos.leetcode;

public class NumberOfStringPairs {
    public static void main(String[] args) {
//        System.out.println("asd".hashCode());
//        System.out.println("dsa".hashCode());
        System.out.println(new NumberOfStringPairs().maximumNumberOfStringPairs(new String[]{"ab", "ba", "cc"}));
    }

    public int maximumNumberOfStringPairs(String[] words) {
        int[] hashes = new int[255];
        for (String s : words) {
            char[] chars = s.toCharArray();
            int hash = 0;
            for (char c : chars) {
                hash += c;
            }
            hashes[hash]++;
        }
        int res = 0;
        for (int h : hashes) {
            if (h == 2) res++;
        }
        return res;
    }
}
