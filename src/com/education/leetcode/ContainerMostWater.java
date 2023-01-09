package com.education.leetcode;

public class ContainerMostWater {

    public static void main(String[] args) {
        ContainerMostWater water = new ContainerMostWater();
        System.out.println(water.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7, 2, 3, 6}));
        System.out.println(water.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(water.maxArea(new int[]{1, 2, 4, 3}));
        System.out.println(water.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 25, 7}));
    }

    public int maxArea(int[] height) {
       int max = 0;
       for (int l = 0, r = height.length - 1; l < r; ) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
       }
       return max;
    }

}
