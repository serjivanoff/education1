package com.education.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DepthFirstTraverse {
    public static void main(String[] args) throws IOException {
        DepthFirstTraverse quiz = new DepthFirstTraverse();
        Node start = quiz.buildGraph("nodes.txt");
        quiz.depthFirstTraverse(start);
        System.out.println();
    }

    private int depthFirstTraverse(Node root) {
        Stack<Node> stack = new Stack<>();
        int result = 1;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node next = findFirstUnvisitedChild(stack.peek());
            if (next != null) {
                result++;
                next.visited = true;
                stack.push(next);
            } else {
                stack.pop();
            }
        }
        return result;
    }

    private Node findFirstUnvisitedChild(Node node) {
        for (Node n: node.children) {
            if (!n.visited) return n;
        }
        return null;
    }

    private Node buildGraph(String fileName) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(DepthFirstTraverse.class.getResourceAsStream(fileName)))){
            String line = br.readLine();
            Map<String, Node> nodes = new HashMap<>();
            Node start = new Node(line.split(" ")[1]);
            nodes.put(start.name, start);
            while ((line = br.readLine()) != null) {
                String[] split = line.split(" ");
                Node from = nodes.computeIfAbsent(split[0], Node::new);
                Node to = nodes.computeIfAbsent(split[1], Node::new);
                from.children.add(to);
            }
            return start;
        }
    }
    private static class Node {
        Set<Node> children;
        final String name;
        boolean visited;

        private Node(String name) {
            this.name = name;
            this.children = new HashSet<>();
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
