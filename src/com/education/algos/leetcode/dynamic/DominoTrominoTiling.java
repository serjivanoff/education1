package com.education.algos.leetcode.dynamic;

public class DominoTrominoTiling {
    public static void main(String[] args) {
        System.out.println(new DominoTrominoTiling().numTilings(60));
    }

    public int numTilings(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = 2 * (dp[i - 1] % 1000000007) + dp[i - 3] % 1000000007;
        }
        return (int) (dp[n] % 1000000007);
    }
}
