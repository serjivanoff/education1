package com.education.algos.astar;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        final Node N = new Node(50, 50);
        Queue<Node> queue= new PriorityQueue<>((n1, n2) -> getDist(n1, n2));
        for (int i = 100; i > 0; i--) {
            queue.add(new Node(i, i));
        }

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(getDist(N, poll));
        }
    }
    private static int getDist(Node n1, Node n2) {
        return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
