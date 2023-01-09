package com.education.leetcode;

import java.util.*;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestSubstring().lengthOfLongestSubstring("umvejcuuk"));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> substr = new LinkedHashSet<>();
        int size = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (substr.contains(c)) {
                removeFromHead(substr, c);
            }
            substr.add(c);
            size = Math.max(size, substr.size());
        }
        return size;
    }

    private void removeFromHead(Set<Character> substr, char c) {
        Iterator<Character> i = substr.iterator();
        Character next;
        do {
            next = i.next();
            i.remove();
        } while (c != next);
    }
}
