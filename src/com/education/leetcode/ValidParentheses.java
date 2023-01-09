package com.education.leetcode;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private static final Map<Character, Character> CLOSING_VS_OPENING = Map.of(')', '(', ']', '[', '}', '{');

    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            Character opening = CLOSING_VS_OPENING.get(c);
            if (opening == null) stack.push(c);
            else if (stack.isEmpty() || opening != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
