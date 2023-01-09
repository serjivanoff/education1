package com.education.stepik;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Parentheses {
    private static final Stack<Node> stack = new Stack<>();
    private static final Set<Character> opens = Set.of('{', '[', '(');
    private static final Set<Character> closes = Set.of('}', ']', ')');
    private static final Map<Character, Character> openByClose = Map.of('}', '{', ')', '(', ']', '[');

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int result = checkString(s);
        System.out.println(result == -1 ? "Success" : result + 1);
    }

    private static int checkString(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(closes.contains(c)) {
                if (stack.isEmpty() || stack.pop().value != openByClose.get(c))
                return i;
            }
            if(opens.contains(c)) {
                stack.push(new Node(c, i));
            }
        }
        return stack.isEmpty() ? -1 : stack.pop().index;
    }

    private static class Node {
        final char value;
        final int index;

        public Node(char value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
