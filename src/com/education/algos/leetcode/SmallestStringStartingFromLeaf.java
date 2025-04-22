package com.education.algos.leetcode;

import java.util.*;

public class SmallestStringStartingFromLeaf {
    public static void main(String[] args) {
        System.out.println(new SmallestStringStartingFromLeaf().smallestFromLeaf(new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(3), new TreeNode(4)))));
        System.out.println(new SmallestStringStartingFromLeaf().smallestFromLeaf(new TreeNode(25, new TreeNode(1, new TreeNode(1), new TreeNode(3)), new TreeNode(3, new TreeNode(0), new TreeNode(2)))));
    }

    public String smallestFromLeaf(TreeNode root) {
        if (isLeaf(root)) {
            return String.valueOf((char) (root.val + 97));
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<List<Integer>> words = new Stack<>();
        stack.push(root);
        ArrayList<Integer> word = new ArrayList<>();
        word.add(root.val);
        words.push(word);
        Set<String> strs = new TreeSet<>();
        while (!stack.isEmpty()) {
            TreeNode next = stack.pop();
            List<Integer> w = words.pop();
            TreeNode l = next.left, r = next.right;
            if (l != null) {
               processNextWord(l, w, stack, strs, words);
            }
            if (r != null) {
                processNextWord(r, w, stack, strs, words);
            }
        }
        return strs.iterator().next();
    }

    private void processNextWord(TreeNode n, List<Integer> w, Stack<TreeNode> stack, Set<String> strs, Stack<List<Integer>> words) {
        List<Integer> nextWord = new ArrayList<>(w);
        nextWord.add(n.val);
        if (isLeaf(n)) {
            strs.add(convertToString(nextWord));
        } else {
            stack.push(n);
            words.push(nextWord);
        }
    }
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private String convertToString(List<Integer> vals) {
        char[] chars = new char[vals.size()];
        int k = 0;
        for (int i = vals.size() - 1; i >= 0; i--) {
            chars[k++] = (char) (vals.get(i) + 97);
        }
        return new String(chars);
    }
}
