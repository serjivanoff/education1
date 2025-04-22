package com.education.algos.leetcode;

public class SingleNumber {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 3, 4, 7, 5};
        int a = array[0];
        for (int i = 1; i < array.length; i++) {
            a^= array[i];
        }
        System.out.println(a);
    }
}
