package com.education.algos.leetcode;

public class FinalValueAfterOperations {
    public static void main(String[] args) {
        System.out.println(new FinalValueAfterOperations().finalValueAfterOperations(new String[] {"X++","++X","--X","X--"}));
    }

    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String s: operations) if (s.toCharArray()[1] == '+') res++; else res --;
        return res;
    }
}
