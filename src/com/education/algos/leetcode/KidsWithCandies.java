package com.education.algos.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public static void main(String[] args) {
        System.out.println(new KidsWithCandies().kidsWithCandies(new int[]{4,2,1,1,2}, 1));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> result = new ArrayList<>(n);
        int max = candies[0];
        for (int i : candies)
            if (max < i) max = i;
        for (int i : candies)
            result.add((max <= i + extraCandies));
        return result;
    }

}
