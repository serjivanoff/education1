package com.education.algos.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSumIII {

    public static void main(String[] args) {
//        System.out.println(new CombinationSumIII().combinationSum3(3, 7));
        System.out.println(new CombinationSumIII().combinationSum3(3, 9));
//        System.out.println(new CombinationSumIII().combinationSum3(4, 1));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Deque<Node> nodes = new ArrayDeque<>();
        int i = 9;
        while (i > n || i == n && k > 1) i--;
        for (int j = i; j > 0; j--) {
            nodes.add(new Node(j, 1, j));
            while (!nodes.isEmpty()) {
                Node node = nodes.pop();
                for (int ii = node.val - 1; ii > 0; ii--) {
                    int newSum = node.sum + ii;
                    if (newSum > n) continue;
                    int newQty = node.qty + 1;
                    if (newSum < n) {
                        nodes.push(new Node(newSum, newQty, ii, node));
                    } else {
                        if (newQty == k) {
                            List<Integer> list = getList(node);
                            list.add(ii);
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

    private List<Integer> getList(Node n) {
        List<Integer> result = new ArrayList<>();
        result.add(n.val);
        Node parent = n.parent;
        while (parent != null) {
            result.add(parent.val);
            parent = parent.parent;
        }
        return result;
    }

    private static class Node {
        int sum, qty, val;
        Node parent;

        public Node(int sum, int qty, int val, Node parent) {
            this(sum, qty, val);
            this.parent = parent;
        }

        public Node(int sum, int qty, int val) {
            this.sum = sum;
            this.qty = qty;
            this.val = val;
        }
    }

}

