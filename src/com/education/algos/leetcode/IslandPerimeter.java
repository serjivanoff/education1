package com.education.algos.leetcode;

public class IslandPerimeter {
    public static void main(String[] args) {
        System.out.println(new IslandPerimeter().islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
    }

    public int islandPerimeter(int[][] grid) {
        int[][] sums = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int g = grid[i][j], s = 0;
                if (g == 1) {
                    s += 4;
                    if (i != 0 && sums[i - 1][j] != 0) {
                        sums[i - 1][j] = sums[i - 1][j] - 1;
                        s--;
                    }
                    if (j != 0 && sums[i][j - 1] != 0) {
                        sums[i][j - 1] = sums[i][j - 1] - 1;
                        s--;
                    }
                    sums[i][j] = s;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans += sums[i][j];
            }
        }
        return ans;
    }

}
