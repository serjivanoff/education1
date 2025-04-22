package com.education.algos.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(12)), new TreeNode(6, new TreeNode(5), new TreeNode(12)));
//        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(4, null, new TreeNode(1)), new TreeNode(2)), null);
        root = new AddOneRowTree().addOneRow(root, -1, 4);
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        if (depth == 2) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depths = new LinkedList<>();
        queue.add(root);
        depths.add(1);
        int target = depth - 1;
        while (!queue.isEmpty()) {
            TreeNode next = queue.poll();
            int d = depths.poll();
            TreeNode l = next.left, r = next.right;
            if (d == target) {
                next.left = new TreeNode(val, l, null);
                next.right = new TreeNode(val, null, r);
                continue;
            }
            if (l != null || r != null) d++;
            if (l != null) {
                queue.add(l);
                depths.add(d);
            }
            if (r != null) {
                queue.add(r);
                depths.add(d);
            }
        }
        return root;
    }
}
