package com.education.algos.leetcode;

public class DecodeMessage {

    public static void main(String[] args) {
        System.out.println(new DecodeMessage().decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        System.out.println(new DecodeMessage().decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }

    public String decodeMessage(String key, String message) {
        char[] hashes = new char[128];
        hashes[32] = 32;
        char[] aBet = new char[26];
        for (int i = 0; i < 26; i++) {
            aBet[i] = (char) (97 + i);
        }
        char[] kChars = key.toCharArray();
        int i = 0;
        for (char c : kChars) {
            char hash = hashes[c];
            if (hash == 0) {
                hashes[c] = aBet[i++];
            }
            if (i == 26) break;
        }
        char[] mChars = message.toCharArray();
        char[] result = new char[mChars.length];
        for (int j = 0; j < mChars.length; j++) {
            result[j] = hashes[mChars[j]];
        }
        return new String(result);
    }
}
