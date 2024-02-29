package com.education.algos.leetcode;

import java.util.Arrays;

public class MaxWidthOfVerticalArea {

    public static void main(String[] args) {
        System.out.println(new MaxWidthOfVerticalArea().maxWidthOfVerticalArea(new int[][]{{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}}));
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        int length = points.length;
        if (length == 2) return Math.abs(points[0][0] - points[1][0]);
        int[] xs = new int[length];
        for (int i = 0; i < length; i++) {
            xs[i] = points[i][0];
        }
        Arrays.sort(xs);
        int ans = xs[1] - xs[0];
        for (int i = 1; i < xs.length; i++) {
            int next = xs[i] - xs[i - 1];
            if (next > ans) ans = next;
        }
        return ans;
    }
}
