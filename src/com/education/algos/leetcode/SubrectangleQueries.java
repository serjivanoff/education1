package com.education.algos.leetcode;

public class SubrectangleQueries {
    private final int[][] rec;

    public static void main(String[] args) {
        SubrectangleQueries inst = new SubrectangleQueries(new int[][]{{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}});
        System.out.println(inst.getValue(0, 2));
        inst.updateSubrectangle(0, 0, 3, 2, 5);
    }

    public SubrectangleQueries(int[][] rectangle) {
        rec = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = col1; i <= col2; i++) {
            for (int j = row1; j <= row2; j++) {
                rec[j][i] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rec[row][col];
    }
}
