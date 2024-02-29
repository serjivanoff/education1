package com.education.algos.leetcode;

public class MaximumNumberWordsSentences {

    public static void main(String[] args) {
        System.out.println(new MaximumNumberWordsSentences().mostWordsFound(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"}));
    }

    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (String s : sentences) {
            int qty = 0;
            if (s.length() == 1) {
                if (res < 1) res = 1;
                continue;
            }
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == ' ') qty++;
            }
            if (res < ++qty) res = qty;
        }
        return res;
    }
}
