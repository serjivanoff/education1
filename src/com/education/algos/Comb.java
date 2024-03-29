package com.education.algos;

import java.util.LinkedList;

public class Comb {
    public static void main(String[] args) {
        System.out.println(comb(3, 5));
    }

    public static String bitPrint(int u) {
        String s = "";
        for (int n = 0; u > 0; ++n, u >>= 1)
            if ((u & 1) > 0) s += n + " ";
        return s;
    }

    public static int bitCount(int u) {
        int n;
        for (n = 0; u > 0; ++n, u &= (u - 1)) ;//Turn the last set bit to a 0
        return n;
    }

    public static LinkedList<String> comb(int c, int n) {
        LinkedList<String> s = new LinkedList<>();
        for (int u = 0; u < 1 << n; u++)
            if (bitCount(u) == c) s.push(bitPrint(u));
        return s;
    }
}
