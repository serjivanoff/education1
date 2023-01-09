package com.education.algos.astar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AStar {
    public static void main(String[] args) throws IOException {
        final AStar aStar = new AStar();
        final Map<String, Node> nodes = aStar.buildGraph("routes.txt");
        Node end = aStar.findShortestPath(nodes.get("A"), nodes.get("I"));
    }

    private Node findShortestPath(final Node start, final Node end) {
        final Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.priority));
        queue.add(start);
        int i = 0;
        while (!queue.isEmpty()) {
            i++;
            final Node node = queue.poll();
            if (node == end) break;
            final int distance = node.distanceToStart;
            node.visited = true;
            node.neighbours.forEach(n -> {
                final int distanceToStart = distance + n.distance;
                if (n.to.distanceToStart > distanceToStart) {
                    n.to.distanceToStart = distanceToStart;
                    n.to.nextToStart = node;
                    n.to.priority = 2 * distanceToStart + Math.abs(end.X - n.to.X) + Math.abs(end.Y - n.to.Y);
                }
                if (!n.to.visited)
                    queue.add(n.to);
            });
        }
        System.out.println(i);
        return end;
    }

    @SuppressWarnings("all")
    private Map<String, Node> buildGraph(final String fileName) throws IOException {
        try (final BufferedReader bf = new BufferedReader(new InputStreamReader(AStar.class.getResourceAsStream(fileName)))) {
            String line;
            boolean routes = false;
            Node start = null;
            final Map<String, Node> nodes = new HashMap<>();
            while ((line = bf.readLine()) != null) {
                String[] split = line.split(" ");
                if (split.length == 2) {
                    routes = true;
                    start = nodes.get(split[1]);
                    start.distanceToStart = 0;
                    continue;
                }
                if (!routes) {
                    nodes.put(split[0], new Node(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2])));
                } else {
                    final String fromName = split[0], toName = split[1];
                    final int distance = Integer.parseInt(split[2]);
                    final Node from = nodes.get(fromName), to = nodes.get(toName);
                    from.neighbours.add(new Path(to, distance));
                    to.neighbours.add(new Path(from, distance));
                }
            }
            return nodes;
        }
    }

    private static class Node {
        final Set<Path> neighbours = new HashSet<>();
        int distanceToStart = Integer.MAX_VALUE;
        Node nextToStart;
        final String name;
        boolean visited;
        final int X, Y;
        int priority;

        public Node(final String name, final int X, final int Y) {
            this.name = name;
            this.X = X;
            this.Y = Y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return X == node.X && Y == node.Y && name.equals(node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, X, Y);
        }
    }

    private static class Path {
        final Node to;
        final int distance;

        public Path(Node to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
}
