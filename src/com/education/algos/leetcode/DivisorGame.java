package com.education.algos.leetcode;

public class DivisorGame {
    public static void main(String[] args) {
        System.out.println(new DivisorGame().divisorGame(37));
    }

    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}
