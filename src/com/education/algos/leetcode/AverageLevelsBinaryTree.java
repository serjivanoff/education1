package com.education.algos.leetcode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree {

    public static void main(String[] args) {
//        Integer[] array = new Integer[]{3, 9, 20, null, null, 15, 7};
//        Integer[] array = new Integer[]{3, 9, 20, 15, 7};
//        Integer[] array = new Integer[]{5, 14, null, 1};
//        Integer[] array = new Integer[]{3, null, 30, 10, null, null, 15, null, 45};
        Integer[] array = new Integer[]{98, 97, null, 88, null, 84, null, 79, 87, 64, null, null, null, 63, 69, 62, null, null, null, 30, null, 27, 59, 9, null, null, null, 3, null, 0, null, -4, null, -16, null, -18, -7, -19, null, null, null, -23, null, -34, null, -42, null, -59, null, -63, null, -64, null, -69, null, -75, null, -81};
        AverageLevelsBinaryTree quiz = new AverageLevelsBinaryTree();
        TreeNode root = quiz.buildTree(array);
        List<Double> list = quiz.averageOfLevels(root);
    }


    private TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return new TreeNode(0);
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < array.length) {
            TreeNode current = queue.poll();
            Integer l = array[i++], r = i < array.length ? array[i++] : null;
            if (l != null) {
                current.left = new TreeNode(l);
                queue.add(current.left);
            }
            if (r != null) {
                current.right = new TreeNode(r);
                queue.add(current.right);
            }
        }
        return root;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> result = new ArrayList<>();
        do {
            long sum = 0;
            int size = queue.size(), turn = size;
            while (size > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size --;
            }
            result.add(sum / (double) turn);
        } while (!queue.isEmpty());
        return result;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

}
