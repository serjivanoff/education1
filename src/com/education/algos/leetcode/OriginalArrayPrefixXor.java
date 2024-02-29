package com.education.algos.leetcode;

import java.util.Arrays;

public class OriginalArrayPrefixXor {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new OriginalArrayPrefixXor().findArray(new int[]{5,2,0,3,1})));
        System.out.println(Arrays.toString(new OriginalArrayPrefixXor().findArray(new int[]{13})));
    }

    public int[] findArray(int[] pref) {
        int[] res = new int[pref.length];
        res[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            res[i] = pref[i - 1] ^ pref[i];
        }
        return res;
    }
}
