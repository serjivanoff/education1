package com.education.algos.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleI {
    public static void main(final String[] args) {
        System.out.println(new PascalTriangleI().generate(30));
    }

    public List<List<Integer>> generate(final int numRows) {
        final List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(List.of(1));
        if (numRows == 1) {
            return result;
        }
        for (int i = 1; i < numRows; i++) {
            final List<Integer> next = new ArrayList<>(i + 1);
            next.add(1);
            final List<Integer> prev = result.get(i - 1);
            for (int j = 1; j < i; j++) {
                next.add(prev.get(j - 1) + prev.get(j));
            }
            next.add(1);
            result.add(next);
        }
        return result;
    }
}
