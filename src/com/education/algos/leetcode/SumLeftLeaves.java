package com.education.algos.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SumLeftLeaves {
    public static void main(String[] args) {
        System.out.println(new SumLeftLeaves().sumOfLeftLeaves(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); int sum = 0;
        do {
            TreeNode next = queue.poll(), l = next.left, r = next.right;
            if (l != null) {
                if (isLeaf(l)) sum += l.val;
                else queue.add(l);
            }
            if (r != null) {
                if (!isLeaf(r)) queue.add(r);
            }
        } while (!queue.isEmpty());
        return sum;
    }

    private boolean isLeaf(TreeNode n) {
        return n.right == null && n.left == null;
    }
}

