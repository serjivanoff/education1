package com.education.algos.leetcode;

import java.util.Stack;

public class MakeStringGreat {
    public static void main(String[] args) {
        System.out.println(new MakeStringGreat().makeGood("abBAcC"));
        System.out.println(new MakeStringGreat().makeGood("leEeetcode"));
    }

    //"abBAcC" --> "abBA" --> "aA" --> ""
    public String makeGood(String s) {
        if (s.length() == 1) return s;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (!stack.isEmpty() && (Math.abs(stack.peek() - c) == 32)) {
                stack.pop();
            } else stack.push(c);
        }
        int size = stack.size();
        if (size != 0) {
            char[] res = new char[size];
            int i = size - 1; char c = stack.pop();
            res[i--] = c;
            while(!stack.isEmpty()) {
                res[i--] = stack.pop();
            }
            return new String(res);
        }
        return "";
    }
}
