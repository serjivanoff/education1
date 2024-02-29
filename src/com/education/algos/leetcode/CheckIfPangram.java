package com.education.algos.leetcode;

public class CheckIfPangram {

    public static void main(String[] args) {
        System.out.println(new CheckIfPangram().checkIfPangram("qwertyuioplkjhgfdsazxcvbnm"));
    }

    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) return false;
        char[] hashed = new char[123];
        for (int i = 0; i < 26; i++) {
            hashed[97 + i] = 1;
        }
        char[] chars = sentence.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (count > 25) break;
            if (hashed[c] == 1) {
                hashed[c] = 0;
                count++;
            }
        }
        return count > 25;
    }
}
