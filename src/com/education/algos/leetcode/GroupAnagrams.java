package com.education.algos.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = {"ac", "d"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashTable = new HashMap<>();
        for (String s : strs) {
            String hash = hash(s);
            if (hashTable.get(hash) == null) {
                List<String> list = new ArrayList<>();
                list.add(s);
                hashTable.put(hash, list);
            } else {
                hashTable.get(hash).add(s);
            }
        }
        return new ArrayList<>(hashTable.values());
    }

    private String hash(String str) {
        char[] chars = str.toCharArray();
        char[] hash = new char[26];
        for (char c : chars) hash[c - 97]++;
        return new String(hash);
    }
}
