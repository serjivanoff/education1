package com.education.algos.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("egg", "add"));
    }
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>(t.length());
        Set<Character> vals = new HashSet<>(t.length());
        char[] ts = t.toCharArray(), ss = s.toCharArray();
        for (int i = 0; i < ts.length; i++) {
            char k = ts[i];
            Character v = map.get(k);
            char val = ss[i];
            if (v == null) {
                if (vals.contains(val)) return false;
                map.put(k, val);
                vals.add(val);
            } else if ( (int) v != (int) val) return false;
        }
        return true;
    }
}
