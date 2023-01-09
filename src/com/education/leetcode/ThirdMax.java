package com.education.leetcode;

public class ThirdMax {

    public static void main(String[] args) {
        System.out.println(new ThirdMax().thirdMax(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0}));
    }

    public int thirdMax(final int[] nums) {
        if (nums.length < 2) return nums[0];
        if (nums.length < 3) return Math.max(nums[0], nums[1]);
        final Stack stack = new Stack();
        for (int i : nums)
            stack.add(i);
        return stack.getThird();
    }

    private static class Stack {
        final int[] values = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        boolean f = false;

        private void add(int i) {
            if (i == Integer.MIN_VALUE) f = true;
            if (i > values[0]) {
                values[2] = values[1];
                values[1] = values[0];
                values[0] = i;
                return;
            }
            if (i != values[0] && i > values[1]) {
                values[2] = values[1];
                values[1] = i;
                return;
            }
            if (i != values[0] && i != values[1] && i > values[2])
                values[2] = i;
        }

        private int getThird() {
            return (f && values[1] == Integer.MIN_VALUE) || (!f && values[2] == Integer.MIN_VALUE) ? values[0] : values[2];
        }
    }
}
