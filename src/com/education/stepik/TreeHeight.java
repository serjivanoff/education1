package com.education.stepik;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TreeHeight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String s = scanner.nextLine();
        Node node = stringToTree(s);
        System.out.println(getHeight(node));
    }

    private static Node stringToTree(String s) {
        String[] split = s.split(" ");
        int[] parents = new int[split.length];
        Node root = new Node();
        for (int i = 0; i < split.length; i++) {
            int parent = Integer.parseInt(split[i]);
            parents[i] = parent;
            if (parent == -1) {
                root.value = i;
                parents[i] = -2;
            }
        }
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == root.value) {
                root.children.add(new Node(i, root));
                parents[i] = -2;
            }
        }
        while (hasMoreChildren(parents)) {
            for (int i = 0; i < parents.length; i++) {
                if (addNextNode(root, parents[i], i)) {
                    parents[i] = -2;
                }
            }
        }
        return root;
    }

    private static boolean hasMoreChildren(int[] parents) {
        for (int i = 0; i < parents.length; i++)
            if (parents[i] != -2)
                return true;
        return false;
    }

    private static boolean addNextNode(Node root, int parent, int value) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            if (node.value == parent) {
                node.children.add(new Node(value, node));
                return true;
            }
            nodes.addAll(node.children);
        }
        return false;
    }

    private static int getHeight(Node root) {
        Stack<Node> nodes = new Stack<>();
        nodes.push(root);
        Node node = root.children.poll();
        if (node == null) {
            return 1;
        }
        int maxDepth = 1, depth = 1;
        while (node != null || !nodes.isEmpty()) {
            if ((node = node.children.poll()) != null) {
                nodes.push(node);
                depth++;
                if (maxDepth < depth) {
                    maxDepth = depth;
                }
            } else {
                if (nodes.isEmpty()) {
                    return ++maxDepth;
                }
                node = nodes.pop();
                depth--;
            }
        }
        return ++maxDepth;
    }

    private static class Node {
        int value;
        Node parent;
        LinkedList<Node> children = new LinkedList<>();

        public Node() {
        }

        public Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
        }
    }
}
