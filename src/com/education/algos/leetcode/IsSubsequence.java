package com.education.algos.leetcode;

public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence inst = new IsSubsequence();
        System.out.println(inst.isSubsequence("abc", "abcde"));
        System.out.println(inst.isSubsequence("abc", "ahbgdc"));
        System.out.println(inst.isSubsequence("aaaaaa", "bbaaaa"));
    }

    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray(), tChars = t.toCharArray();
        if (sChars.length == 0) return true;
        if (sChars.length > tChars.length) return false;
        int lastFound = 0;
        boolean f = false;
        for (char c_s : sChars) {
            f = false;
            for (int j = lastFound; j < tChars.length; j++) {
                if (c_s == tChars[j]) {
                    lastFound = j + 1;
                    f = true;
                    break;
                }
            }
            if (!f) break;
        }
        return f;
    }
}
