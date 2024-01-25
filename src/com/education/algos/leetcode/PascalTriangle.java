package com.education.algos.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(new PascalTriangle().getRow(4));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
//        int [] result = new int[]{1};
//        for (int i = 0; i < rowIndex; i++) {
//            result = nextRow(result);
//        }
        int [] result = new int[rowIndex + 1];
        result[0] = 1;
        long k = 1;
        for (int i = 1; i<= rowIndex; i++) {
            k = (k*(rowIndex+1 - i))/i;
            result[i] = (int) k;
        }

        for (int i = 0; i < result.length; i++) {
            list.add(result[i]);
        }
        return list;
    }


    private int[] nextRow(int[] previous) {
        final int[] result = new int[previous.length + 1];
        result[0] = 1;
        result[result.length - 1] = 1;
        for (int i = 1; i < previous.length; i++) {
            result[i] = previous[i] + previous[i - 1];
        }
        return result;
    }

}
