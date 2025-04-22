package com.education.algos.leetcode;

import java.util.*;

public class FindPathExistsGraph {
    public static void main(String[] args) {
        System.out.println(new FindPathExistsGraph().validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        System.out.println(new FindPathExistsGraph().validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        Map<Integer, Node> cache = new HashMap<>(n);
        for (int i = 0; i < edges.length; i++) {
            Node src = cache.get(edges[i][0]);
            if (src == null) {
                src = new Node(edges[i][0]);
                cache.put(edges[i][0], src);
            }
            Node dest = cache.get(edges[i][1]);
            if (dest == null) {
                dest = new Node(edges[i][1]);
                cache.put(edges[i][1], dest);
            }
            if (src.val == source && dest.val == destination || src.val == destination && dest.val == source) {
                return true;
            }
            src.neighbours.add(dest);
            dest.neighbours.add(src);
        }
        Node root = cache.get(source);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node next = queue.poll();
            for (Node node : next.neighbours) {
                if (node.val == destination) return true;
                queue.add(node);
            }
            next.neighbours.clear();
        }
        return false;
    }

    private static class Node {
        int val;
        Set<Node> neighbours;

        public Node(int val) {
            this.val = val;
            neighbours = new HashSet<>();
        }
    }
}
