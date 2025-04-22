package com.education.algos.leetcode.dynamic;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
//        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace"));
//        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abc", "abc"));
//        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcde", "def"));
//        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("aaaa", "aaaa"));
//        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        boolean isFirst = l1 < l2;
        int[][] dp = new int[Math.min(l1, l2)][2];
        char[] chars = isFirst ? text1.toCharArray() : text2.toCharArray();
        String second = isFirst ? text2 : text1;
        dp[0][1] = second.indexOf(chars[0]);
        dp[0][0] = dp[0][1] == -1 ? 0 : 1;
        int lastIndex = dp[0][1];
        for (int i = 1; i < chars.length; i++) {
            dp[i][1] = second.indexOf(chars[i], dp[i - 1][1]);
            if (dp[i][1] > lastIndex) {
                dp[i][0] = dp[i - 1][0] + 1;
                lastIndex = dp[i][1];
                continue;
            }
            dp[i][0] = dp[i - 1][0];
        }
        return dp[chars.length - 1][0];
    }
}
