package com.education.algos.djikstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra {
    public static void main(String[] args) throws IOException {
        final Dijkstra dijkstra = new Dijkstra();
        final Node start = dijkstra.buildGraph("routes.txt");
        dijkstra.findShortestPaths(start);
    }

    private void findShortestPaths(final Node start) {
        int i = 0;
        final Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            i++;
            final Node node = queue.poll();
            final int distance = node.distanceToStart;
            node.visited = true;
            node.neighbours.forEach(n -> {
                final int distanceToStart = distance + n.distance;
                if (n.to.distanceToStart > distanceToStart) {
                    n.to.distanceToStart = distanceToStart;
                    n.to.nextToStart = node;
                }
                if (!n.to.visited)
                    queue.add(n.to);
            });
        }
        System.out.println(i);
    }

    private Node buildGraph(final String fileName) throws IOException {
        try (final BufferedReader bf = new BufferedReader(new InputStreamReader(Dijkstra.class.getResourceAsStream(fileName)))) {
            String line = bf.readLine();
            String[] split = line.split(" ");
            final Map<String, Node> nodes = new HashMap<>();
            final Node start = new Node(split[1]);
            start.distanceToStart = 0;
            nodes.put(start.name, start);
            while ((line = bf.readLine()) != null) {
                split = line.split(" ");
                final String fromName = split[0], toName = split[1];
                final int distance = Integer.parseInt(split[2]);
                final Node from = nodes.computeIfAbsent(fromName, Node::new), to = nodes.computeIfAbsent(toName, Node::new);
                from.neighbours.add(new Path(to, distance));
                to.neighbours.add(new Path(from, distance));
                nodes.put(fromName, from);
                nodes.put(toName, to);
            }
            return start;
        }
    }

    private static class Node {
        final Set<Path> neighbours = new HashSet<>();
        int distanceToStart = Integer.MAX_VALUE;
        Node nextToStart;
        final String name;
        boolean visited;

        public Node(String name) {
            this.name = name;
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
