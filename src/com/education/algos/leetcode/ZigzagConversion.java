package com.education.algos.leetcode;

import java.util.Arrays;

public class ZigzagConversion {

    public static void main(String[] args) {
        final String word = "PAYPALISHIRING";
        ZigzagConversion zz = new ZigzagConversion();
        System.out.println(zz.convert(word, 4));
    }

    public String convert(String s, int numRows) {
        char[][] matrix = getEmptyMatrix(s.length(), numRows);
        fillMatrix(matrix, s);
        return readMatrix(matrix);
    }

    private char[][] getEmptyMatrix(int length, int numRows) {
        final int zzLength = numRows <= 2 ? 0 : numRows - 2;
        final int columnsPerStroke = zzLength + 1;
        final int numColumns;
        if (zzLength > 0) {
            final int strokeLength = numRows + zzLength;
            int modulo = length % strokeLength;
            numColumns = columnsPerStroke * (length / strokeLength) + (modulo / numRows > 0 ? modulo % numRows + 1 : modulo == 0 ? 0 : 1);
        } else {
            numColumns = length / numRows + (length % numRows > 0 ? 1 : 0);
        }
        return new char[numRows][numColumns];
    }

    private void fillMatrix(char[][] matrix, String word) {
        final char[] chars = word.toCharArray();
        final int numRows = matrix.length;
        int c = 0, j = 0;
        while (c < chars.length) {
            for (int i = 0; c < chars.length && i < numRows; i++) {
                matrix[i][j] = chars[c++];
            }
            j++;
            for (int i = numRows - 2; c < chars.length && i > 0; i--) {
                matrix[i][j++] = chars[c++];
            }
        }
    }

    private String readMatrix(char[][] matrix) {
        final char[] chars = new char[matrix.length * matrix[0].length];
        int c = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != '\u0000') {
                    chars[c++] = matrix[i][j];
                }
            }
        }
        return new String(Arrays.copyOf(chars, c));
    }
}
