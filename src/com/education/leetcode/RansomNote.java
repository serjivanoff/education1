package com.education.leetcode;

public class RansomNote {

    public static void main(String[] args) {
//        RansomNote r = new RansomNote();
//        System.out.println(r.canConstruct("aa", "aab"));
        System.out.println(0%2);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;
        final char[] source = magazine.toCharArray(), target = ransomNote.toCharArray();
        final int[] indexes = new int[128];
        for (char c : source)
            indexes[c]++;
        for (char c : target)
            if (indexes[c]-- == 0)
                return false;
        return true;
    }
}
