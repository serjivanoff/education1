package com.education.algos.leetcode;

public class GoalParser {
    public static void main(String[] args) {
        System.out.println(new GoalParser().interpret("(al)G(al)()()G"));
    }

    public String interpret(String command) {
        if (command.length() == 1) return command;
        char[] chars = command.toCharArray();
        char[] res = new char[chars.length];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                if (chars[i + 1] == ')') {
                    res[j++] = 'o';
                    i++;
                    continue;
                }
                res[j++] = 'a';
                res[j++] = 'l';
                i +=3;
            } else {
                res[j++] = 'G';
            }
        }
        return new String(res, 0, j);
    }
}
