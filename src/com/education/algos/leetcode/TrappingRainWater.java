package com.education.algos.leetcode;

import java.util.Stack;

public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new TrappingRainWater().trap(new int[]{3, 2, 1, 0, 2, 3}));
        System.out.println(new TrappingRainWater().trap(new int[]{2, 0, 1, 3}));
    }

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        stack.push(height[0]);
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            int h = height[i];
            if (h > stack.peek()) {
                Stack<Integer> stones = new Stack<>();
                while (!stack.isEmpty() && h >= stack.peek()) {
                    stones.push(stack.pop());
                }
                int eh = stack.isEmpty() ? stones.pop() : h, sum = 0;
                while (!stones.isEmpty()) {
                    sum += eh - stones.pop();
                    if (!stack.isEmpty()) {
                        stack.push(eh);
                    }
                }
                res += sum;
            }
            stack.push(h);
        }
        return res;
    }
}
