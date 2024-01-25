package com.education.algos.leetcode;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits().countBits(100_000)));
    }

    public int[] countBits(int n) {
        if (n == 0) return new int[]{0};
        if (n == 1) return new int[]{0, 1};
        if (n == 2) return new int[]{0, 1, 1};
        if (n == 3) return new int[]{0, 1, 1, 2};
        int[] bits = new int[n + 1];
        bits[0] = 0; bits[1] = 1; bits[2] = 1; bits[3] = 2;
        int max = 2, i = 4;
        do {
            int j = 1, next = 1;
            bits[i++] = 1;
            while (i <= n && next <= max) {
                next = bits[j++] + 1;
                bits[i++] = next;
            }
            if (max < next) max = next;
        } while (i <= n);
        return bits;
    }
}
