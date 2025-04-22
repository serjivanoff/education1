package com.education.algos.leetcode;

import java.util.Stack;

public class MaxNestingDepthParentheses {
    public static void main(String[] args) {

    }

    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int max = 0, depth = 0;
        for (char c: chars) {
            if (c == '(') {
                stack.push(c);
                depth++;
                if (max < depth) max = depth;
            } else if (c == ')') {
                stack.pop();
                depth--;
            }
        }
        return max;
    }
}

