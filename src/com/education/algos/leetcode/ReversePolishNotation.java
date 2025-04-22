package com.education.algos.leetcode;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(new ReversePolishNotation().evalRPN(new String[]{"3","-4","+"}));
    }

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        Stack<Integer> operands = new Stack<>();
        for (String t : tokens) {
            char[] chars = t.toCharArray();
            if (chars[0] < 59 && chars[0] > 47 || (chars[0] == '-' && chars.length > 1 && chars[1]< 59 && chars[1] > 47)) {
                operands.push(Integer.parseInt(t));
                continue;
            }
            int i1 = operands.pop(), i2 = operands.isEmpty() ? 0 : operands.pop();
            int res = 0;
            switch (chars[0]) {
                case '/': res = i2 / i1; break;
                case '*': res = i2 * i1; break;
                case '+': res = i2 + i1; break;
                case '-': res = i2 - i1; break;
            }
            operands.push(res);
        }
        return operands.pop();
    }
}
