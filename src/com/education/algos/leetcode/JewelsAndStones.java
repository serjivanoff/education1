package com.education.algos.leetcode;

public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(new JewelsAndStones().numJewelsInStones("aA", "aAAbbbb"));
    }

    public int numJewelsInStones(String jewels, String stones) {
        int[] hashes = new int[128];
        char[] jChars = jewels.toCharArray();
        for (char c: jChars) {
            hashes[c] = 1;
        }
        int result = 0;
        char[] sChars = stones.toCharArray();
        for (char c: sChars) {
            if (hashes[c] == 1) result++;
        }
        return result;
    }
}
