package com.education.leetcode;

import java.util.Map;
//      Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
public class RomanToIntegers {
    private static final Map<Character, Integer> romans = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMCDVX"));
    }

    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int cur = romans.get(chars[0]);
        int result = cur;
        for (int i = 1; i < chars.length; i++) {
            int next = romans.get(chars[i]);
            if (cur < next) {
                result =  result + next - 2 * cur;
            } else {
                result += next;
            }
            cur = next;
        }
        return result;
    }
}
