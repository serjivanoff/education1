package com.education.algos.leetcode;

import java.util.Arrays;

public class SortPeople {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortPeople().sortPeople(new String[]{"Alice", "Bob", "Bob"}, new int[]{155, 185, 150})));
        System.out.println(Arrays.toString(new SortPeople().sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
    }

    public String[] sortPeople(String[] names, int[] heights) {
        int[] hashed = new int[100_001];
        Arrays.fill(hashed, -1);
        int length = heights.length - 1;
        for (int i = 0; i <= length; i++) hashed[heights[i]] = i;
        String[] res = new String[names.length];
        int j = 0;
        for (int i = 100_000; i >= 0; i--) {
            int next = hashed[i];
            if (next != -1) {
                res[j++] = names[next];
            }
            if (j > length) break;
        }
        return res;
    }
}
