package com.education.algos;

import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        char[] src = new char[]{'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(src));
        int[] a = new int[]{0, 1, 2, 3};
        int i = 1, n = src.length;
        while (i < n) {
            a[i]--;
            int j = i % 2 * a[i];
            swap(src, i, j);
            System.out.println(Arrays.toString(src));
            i = 1;
            while ( i < n && a[i] == 0) {
                a[i] = i; i++;
            }
        }
    }

    private static void swap(char[] array, int from, int to) {
        if (from == to) return;
        char a = array[to];
        array[to] = array[from];
        array[from] = a;
    }

    public List<String> readBinaryWatch(int turnedOn) {
        return null;
    }
}
