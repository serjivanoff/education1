package com.education.algos.leetcode;

import com.education.algos.DepthFirstTraverse;

import java.util.*;

public class MaxDepthNRayTree {

    public static void main(String[] args) {
        MaxDepthNRayTree quiz = new MaxDepthNRayTree();
        Node root = quiz.buildTree(new Integer[]{1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14});
//        Node root = quiz.buildTree(new Integer[]{1, null, 3, 2, 4, null, 5, 6});
//        Node root = quiz.buildTree(new Integer[]{});
        System.out.println(quiz.maxDepth(root));
    }

    private Node findFirstUnvisitedChild(List<Node> nodes, Set<Node> visited) {
        for (Node n : nodes) {
            if (!visited.contains(n)) return n;
        }
        return null;
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        int result = 1;
//        Set<Node> visited = new HashSet<>();
//        visited.add(root);
        while (!stack.isEmpty()) {
            List<Node> children = stack.peek().children;
            Node next = !children.isEmpty() ? children.remove(children.size() - 1) : null;
            if (next != null) {
//                visited.add(next);
                stack.push(next);
                if (result < stack.size()) result = stack.size();
            } else {
                stack.pop();
            }
        }
        return result;
    }

    private Node buildTree(Integer[] nodes) {
        Node root = new Node(nodes[0], new ArrayList<>());
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 2;
        while (!queue.isEmpty() && i < nodes.length) {
            Node current = queue.poll();
            while (i < nodes.length && nodes[i] != null) {
                Node node = new Node(nodes[i++], new ArrayList<>());
                current.children.add(node);
                queue.add(node);
            }
            i++;
        }
        return root;
    }

    private int[] visited() {
        int[] result = new int[10_000];
        Arrays.fill(result, -1);
        return result;
    }

    private Node findFirstUnvisited(List<Node> nodes, int[] visited) {
        for (Node n : nodes) {
            if (visited[n.val] == -1) return n;
        }
        return null;
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
