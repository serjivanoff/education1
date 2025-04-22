package com.education.algos.leetcode;

import java.util.Stack;

public class SumRootLeafNumbers {
    public static void main(String[] args) {
        System.out.println(new SumRootLeafNumbers().sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(new SumRootLeafNumbers().sumNumbers(new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0))));
        System.out.println(new SumRootLeafNumbers().sumNumbers(new TreeNode(1, new TreeNode(5), new TreeNode(1, null, new TreeNode(6)))));
        System.out.println(new SumRootLeafNumbers().sumNumbers(new TreeNode(9, new TreeNode(0), new TreeNode(3, new TreeNode(2, new TreeNode(3), new TreeNode(4, null, new TreeNode(7))), null))));
    }

    public int sumNumbers(TreeNode root) {
        if (root.right == null && root.left == null) return root.val;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> path = new Stack<>();
        stack.push(root);
        int s = 0;
        while (!stack.isEmpty()) {
            TreeNode next = stack.pop();
            if (!path.isEmpty()) {
                while (!path.isEmpty() && !isParent(path.peek(), next)) {
                    path.pop();
                }
                path.push(next);
            } else {
                path.push(next);
            }
            TreeNode l = next.left, r = next.right;
            if (l != null) stack.push(l);
            if (r != null) stack.push(r);
            if (isLeaf(next))
                s += convertToNumber(path);
        }
        return s;
    }

    private boolean isParent(TreeNode parent, TreeNode child) {
        return parent.left == child || parent.right == child;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private int convertToNumber(Stack<TreeNode> vals) {
        int ans = 0, i = 1, k = 0;
        TreeNode[] buf = new TreeNode[vals.size()];
        do {
            buf[k] = vals.pop();
            ans += buf[k++].val * i;
            i *= 10;
        } while (!vals.isEmpty());
        k--;
        for (; k > 0; k--) vals.push(buf[k]);
        return ans;
    }

}
