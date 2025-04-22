package com.education.algos.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EatLunch {

    public static void main(String[] args) {
        System.out.println(new EatLunch().countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
        System.out.println(new EatLunch().countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Boolean> sandwich = new Stack<>();
        Queue<Boolean> student = new LinkedList<>();
        int qty = students.length;
        for (int i = 0; i < qty; i++) {
            sandwich.push(sandwiches[qty - 1 - i] == 1);
            student.add(students[i] == 1);
        }
        boolean f = true;
        do{
            boolean meal = sandwich.peek(), human = student.poll();
            if (meal == human) {
                qty = student.size();
                sandwich.pop();
            } else {
                qty--;
                student.add(human);
            }
        } while (qty > 0 && !sandwich.isEmpty());
        return sandwich.size();
    }
}
