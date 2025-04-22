package com.education.algos.leetcode;

import java.util.*;

public class ArrayMediumTier {
    public static void main(String[] args) {
        ArrayMediumTier instance = new ArrayMediumTier();
//        System.out.println(instance.groupThePeople(new int[]{3, 4, 3, 3, 4, 4, 3, 4, 3, 3}));
//        System.out.println(instance.findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1}));
//        System.out.println(instance.findMatrix(new int[]{1, 2, 3, 4}));

//        System.out.println(Arrays.toString(instance.countPoints(new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}}, new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}})));
//        System.out.println(Arrays.toString(instance.countPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}, new int[][]{{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}})));

//        System.out.println(instance.maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));
//        System.out.println(instance.maxIncreaseKeepingSkyline(new int[][]{{59, 88, 44}, {3, 18, 38}, {21, 26, 51}}));

//        System.out.println(instance.numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
//        System.out.println(instance.numberOfBeams(new String[]{"000","111","000"}));

        instance.setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }


    public void setZeroes(int[][] matrix) {
        boolean[] is = new boolean[matrix.length], js = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    is[i] = true;
                    js[j] = true;
                }
            }
        }
        for (int i = 0; i < is.length; i++) {
            if (is[i]) Arrays.fill(matrix[i], 0);
        }
        for (int i = 0; i < js.length; i++) {
            if (js[i]) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public int numberOfBeams(String[] bank) {
        int res = 0, qty = 0;
        for (String s : bank) {
            char[] chars = s.toCharArray();
            int nextQty = 0;
            for (char c : chars) {
                if (c == '1') nextQty++;
            }
            if (nextQty == 0) continue;
            if (qty == 0) {
                qty = nextQty;
                continue;
            }
            res = res + qty * nextQty;
            qty = nextQty;
        }
        return res;
    }

    //807
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int length = grid.length;
        int[] maxrs = new int[length], maxcs = new int[length];
        for (int i = 0; i < length; i++) {
            int maxr = grid[i][0];
            int maxc = grid[0][i];
            for (int j = 1; j < length; j++) {
                if (maxr < grid[i][j]) maxr = grid[i][j];
                if (maxc < grid[j][i]) maxc = grid[j][i];
            }
            maxrs[i] = maxr;
            maxcs[i] = maxc;
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int max = maxcs[j] < maxrs[i] ? maxcs[j] : maxrs[i];
                int d = max - grid[i][j];
                if (d > 0) res += d;
            }
        }
        return res;
    }

    //1828
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] circle = queries[i];
            int r2 = circle[2] * circle[2], qty = 0;
            for (int[] p : points) {
                if (sq(circle[0] - p[0]) + sq(circle[1] - p[1]) <= r2) {
                    qty++;
                }
            }
            res[i] = qty;
        }
        return res;
    }

    private int sq(int arg) {
        return arg * arg;
    }

    //1282
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int gs = groupSizes[i];
            List<Integer> group = map.computeIfAbsent(gs, k -> new ArrayList<>());
            group.add(i);
        }
        final ArrayList<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            List<Integer> v = e.getValue();
            int k = e.getKey();
            int size = v.size();
            if (size <= k) {
                res.add(v);
            } else {
                List<Integer> next = new ArrayList<>(k);
                int j = 0;
                for (int i = 0; i < size; i++) {
                    next.add(v.get(i));
                    if (++j % k == 0) {
                        res.add(next);
                        next = new ArrayList<>(k);
                        j = 0;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        int[] hashes = new int[201];
        for (int n : nums) {
            hashes[n]++;
        }
        List<List<Integer>> res = new ArrayList<>();
        while (true) {
            List<Integer> next = new ArrayList<>();
            for (int i = 0; i < hashes.length; i++) {
                if (hashes[i] == 0) continue;
                next.add(i);
                hashes[i]--;
            }
            if (next.isEmpty()) break;
            res.add(next);
        }
        return res;
    }
}
