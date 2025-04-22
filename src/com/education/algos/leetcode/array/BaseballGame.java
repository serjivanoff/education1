package com.education.algos.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public static void main(String[] args) {
//        System.out.println(new BaseballGame().calPoints(new String[]{"5", "2", "C", "D", "+"}));
//        System.out.println(new BaseballGame().calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
        System.out.println(new BaseballGame().calPoints(new String[]{"-21","-66","39","+","+"}));
    }

    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();
        int last = -1;
        for (String o : operations) {
            char[] chars = o.toCharArray();
            int c = 0;
            boolean isNumber = false;
            if (chars.length > 1) {
                isNumber = true;
                int dec = 1;
                if (chars[0] == 45) {
                    for (int i = chars.length - 1; i > 0; i--) {
                        c += (chars[i] - 48) * dec;
                        dec *= 10;
                    }
                    c = -c;
                } else {
                    for (int i = chars.length - 1; i >= 0; i--) {
                        c += chars[i] * dec;
                        dec *= 10;
                    }
                }
            } else {
                c = chars[0];
            }
            if (isNumber) {
                list.add(c);
                last++;
                continue;
            }
            if (c < 58 && c > 47) {
                list.add(c - 48);
                last++;
                continue;
            }
            if (c == 43) {
                list.add(list.get(last) + list.get(last - 1));
                last++;
                continue;
            }
            if (c == 68) {
                list.add(list.get(last) * 2);
                last++;
                continue;
            }
            if (c == 67) {
                list.remove(last);
                last--;
            }
        }
        int sum = 0;
        for (int i : list) sum += i;
        return sum;
    }
}
