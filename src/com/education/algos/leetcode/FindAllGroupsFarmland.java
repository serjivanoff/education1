package com.education.algos.leetcode;

import java.util.Arrays;

public class FindAllGroupsFarmland {

    public static void main(String[] args) {
        FindAllGroupsFarmland inst = new FindAllGroupsFarmland();
        int[][] farmland = inst.findFarmland(new int[][]{
                {1, 0, 0},
                {0, 1, 1},
                {0, 1, 1}
        });
        farmland = inst.findFarmland(new int[][]{
                {1, 1},
                {1, 1}
        });
        farmland = inst.findFarmland(new int[][]{
                {1, 1, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 0}
        });
    }

    public int[][] findFarmland(int[][] land) {
        int w = land.length, d = land[0].length;
        int[][] ans = new int[1 + w * d / 2][4];
        int k = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < d; j++) {
                if (land[i][j] == 1) {
                    int col = j, row = i;
                    while (col < d - 1 && land[i][col + 1] == 1) {
                        col++;
                    }
                    while (row < w - 1 && land[row + 1][j] == 1) {
                        row++;
                    }
                    ans[k++] = new int[]{i, j, row, col};
                    fillZeros(i, j, row, col, land);
                }
            }
        }
        return Arrays.copyOf(ans, k);
    }

    private void fillZeros(int sr, int sc, int er, int ec, int[][] land) {
        for (int i = sr; i <= er; i++)
            for (int j = sc; j <= ec; j++)
                land[i][j] = 0;
    }
}
