package com.education.algos.leetcode;

import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {
        System.out.println(new ValidParenthesisString().checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
        System.out.println(new ValidParenthesisString().checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
        System.out.println(new ValidParenthesisString().checkValidString("*)*())"));
        System.out.println(new ValidParenthesisString().checkValidString("()(())(((((()())(()))))()(*()))()()()()((()(())())*((((())))*())()(()()))*((()(()(()))))(()())(*(*"));
    }

    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> indexes = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    indexes.pop();
                } else {
                    stack.push(c);
                    indexes.push(i);
                }
            }
            if (c == '(') {
                stack.push(c);
                indexes.push(i);
            }
        }
        while (!stack.isEmpty()) {
            char c = stack.pop();
            int index = indexes.pop();
            boolean f = false;
            if (c == ')') {
                for (int i = index - 1; i >= 0; i--) {
                    if (chars[i] == '*') {
                        chars[i] = '_';
                        f = true;
                        break;
                    }
                }
            } else if (c == '(') {
                for (int i = index + 1; i < chars.length; i++) {
                    if (chars[i] == '*') {
                        chars[i] = '_';
                        f = true;
                        break;
                    }
                }
            }
            if (!f) return false;
        }
        return true;
    }
}
