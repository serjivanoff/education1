package com.education.algos.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContaining {
    public static void main(String[] args) {
        System.out.println(new FindWordsContaining().findWordsContaining(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'a'));
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>(words.length);
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            for (char c : chars) {
                if (c == x) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}
