package com.education.algos.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryWatch {
    private final int[] leds = new int[]{32, 16, 8, 4, 2, 1, 8, 4, 2, 1};
    private int N = 0, M = 1;

    public static void main(String[] args) {
        BinaryWatch quiz = new BinaryWatch();
        quiz.readBinaryWatch(1);
    }

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn > 8) return new ArrayList<>(2);
        char[] chars = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};
        for (int i = 0; i < turnedOn; i++) {
            chars[i] = '1';
        }
        int[] a = new int[leds.length];
        for (int i = 0; i < leds.length; i++) a[i] = i;
        int n = leds.length, i = 1;
        Set<String> combinations = new HashSet<>();
        List<String> result = new ArrayList<>();
        while (i < n) {
            a[i]--;
            int j = i % 2 * a[i];
            swap(chars, i, j);
            if (combinations.add(new String(chars))) {
                int[] watch = toWatch(chars);
                if (isValid(watch)) {
                    result.add(watch[0] + ":" + (watch[1] < 10 ? "0" + watch[1] : watch[1]));
                }
            }
            i = 1;
            while (i < n && a[i] == 0) {
                a[i] = i;
                i++;
            }
            M++;
        }
        return result;
    }

    private static void swap(char[] array, int from, int to) {
        if (from == to) return;
        char a = array[to];
        array[to] = array[from];
        array[from] = a;
    }

    private int[] toWatch(char[] chars) {
        int h = 0, m = 0;
        for (int i = 0; i < leds.length; i++) {
            if (chars[i] == '1') {
                N++;
                int a = leds[i];
                if (i > 5) h += a;
                else m += a;
            }
        }
        return new int[]{h, m};
    }

    private boolean isValid(int[] watch) {
        return watch[0] < 12 && watch[1] < 60;
    }

}

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    result.add(h + ":" + (m < 10 ? "0" + m: m));
                }
            }
        }
        return result;
    }
}
