package com.education.algos.leetcode.dynamic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KRepeatingStrings {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2}, new int[]{2, 1})));

//        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
//        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 1}, 1));
//        System.out.println("ababc".indexOf("ab"));
//        System.out.println(new KRepeatingStrings().maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

    public int maxRepeating(String sequence, String word) {
        return 0;
    }

    private int count(char[] subsequence, char[] word) {
        return 0;
    }

    //    public TreeNode sortedArrayToBST(int[] nums) {
//        TreeNode root = new TreeNode(nums[0]);
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//        if (nums.length > 1) {
//            int i = nums.length/2;
//            while ()
//            while (!queue.isEmpty()) {
//
//            }
//        }
//        return root;
//    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length && i <= k; i++) {
            if (!set.add(nums[i])) return true;
        }
        for (int l = 0, r = k + 1; l < length && r < length; l++) {
            set.remove(nums[l]);
            if (!set.add(nums[r])) return true;
            r++;
        }
        return false;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] hash1 = new int[1001];
        for (int n : nums1) {
            hash1[n] = hash1[n] + 1;
        }
        int[] hash2 = new int[1001];
        int count = 0;
        for (int n : nums2) {
            if (hash1[n] > 0) {
                hash2[n] = hash2[n] + 1;
            }
        }
        for (int i = 0; i < hash2.length; i++) {
            if (hash2[i] > 0) {
                count += Math.min(hash1[i], hash2[i]);
            }
        }
        int[] res = new int[count];
        for (int i = 0; i < hash2.length; i++) {
            if (hash2[i] > 0) {
                int next = Math.min(hash1[i], hash2[i]);
                for (int j = 0; j < next; j++) res[--count] = i;
            }
        }
        return res;
    }

}
