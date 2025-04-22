package com.education.algos.leetcode.array;

public class RotateImage {
    public static void main(String[] args) {
        int[][] m1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] m2 = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        new RotateImage().rotate(m2);
        System.out.println();
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 1; j++) {

            }
        }
    }
}
