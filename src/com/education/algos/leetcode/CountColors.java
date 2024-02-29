package com.education.algos.leetcode;

public class CountColors {
    public static void main(String[] args) {
        System.out.println(new CountColors().countPoints("B0R0G0R9R0B0G0"));
    }

    public int countPoints(String rings) {
        int[] g = new int[10], r = new int[10], b = new int[10];
        char[] chars = rings.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int color = chars[i++];
            int rod = chars[i] - 48;
            switch (color){
                case 'R': r[rod] = 1; break;
                case 'G': g[rod] = 1 ;break;
                case 'B': b[rod] = 1 ;break;
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            if (r[i] == 1 && g[i] == 1 && b[i] == 1) res ++;
        }
        return res;
    }
}
