package com.education.algos.leetcode;

import java.util.Stack;

public class MakeValidParentheses {
    public static void main(String[] args) {
        System.out.println(new MakeValidParentheses().minRemoveToMakeValid("))(("));
        System.out.println(new MakeValidParentheses().minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(new MakeValidParentheses().minRemoveToMakeValid("a)b(c)d"));
    }

    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> parentheses = new Stack<>();
        Stack<Integer> indexes = new Stack<>();
        int f = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                parentheses.push(c);
                indexes.push(i);
            } else if (c == ')') {
                if (!parentheses.isEmpty() && parentheses.peek() == '(') {
                    parentheses.pop();
                    indexes.pop();
                } else {
                    chars[i] = 0;
                    f++;
                }
            }
        }
        if (f == 0 && indexes.isEmpty()) return s;
        while (!indexes.isEmpty()) {
            chars[indexes.pop()] = 0;
            f++;
        }
        char[] res = new char[chars.length - f];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) res[j++] = chars[i];
        }
        return new String(res);
    }
}
