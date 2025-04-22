package com.education.algos.leetcode;

public class KWeakestRowsMatrix {
    public static void main(String[] args) {
        new KWeakestRowsMatrix().kWeakestRows(new int[][]{{1, 0}, {1, 0}, {1, 0}, {1, 1}}, 4);
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] weaknesses = new int[k];
        boolean[] visited = new boolean[mat.length];
        int counter = 0;
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                if (visited[i]) continue;
                if (mat[i][j] == 0) {
                    weaknesses[counter++] = i;
                    visited[i] = true;
                }
                if (counter >= k) break;
            }
            if (counter >= k) break;
        }
        if (counter < k) {
            for (int i = 0; i < mat.length; i++) {
                if (!visited[i]) {
                    weaknesses[counter++] = i;
                    if (counter == k) break;
                }
            }
        }
        return weaknesses;
    }
}
