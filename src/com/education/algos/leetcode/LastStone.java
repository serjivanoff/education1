package com.education.algos.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStone {
    public static void main(String[] args) {

    }

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        for (int s: stones) queue.add(s);
        while (!queue.isEmpty()) {
            int x = queue.poll(), y = queue.poll();
            if (x != y) {
                queue.add(x - y);
            }
            if (queue.size() == 1) return queue.peek();
        }
        return 0;
    }
}
