package com.education.algos;

import java.util.Arrays;
import java.util.Stack;

public class Calculator {
//    3 + 2 * (3 + 2)

    public static void main(String[] args) {
        new Calculator().read("345");
    }

    private void read(final String arg) {
        char[] chars = arg.toCharArray();
        final Stack<Integer> operands = new Stack<>();
        final Stack<Character> operators = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c <= '9' && c >= '0') {
                int j = i;
                do {
                    c = chars[++j];
                } while (j < chars.length - 1 && c <= '9' && c >= '0');
                operands.push(Integer.parseInt(new String(Arrays.copyOfRange(chars, i, j + 1))));
                i = j;
            }
            if (c == '+') {

            }
        }
    }

}
