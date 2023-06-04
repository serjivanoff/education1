package com.education.algos.leetcode;

import java.util.*;

public class DetonateMaximumBombs {

    public static void main(String[] args) {
        DetonateMaximumBombs quiz = new DetonateMaximumBombs();
        int[][] array = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};
//        int[][] array = {{2, 1, 3}, {6, 1, 4}};
//        int[][] array = {{1, 1, 5}, {10, 10, 5}};
        System.out.println(quiz.maximumDetonation(array));
    }

    public int maximumDetonation(int[][] bombs) {
        int result = 0, length = bombs.length;
        class Bomb {
            private final int i;
            private final List<Bomb> detonated = new ArrayList<>();
            private Bomb(int i) {
                this.i = i;
            }
        }
        Bomb[] cache = new Bomb[length];
        for (int i = 0; i < length; i++) {
            int x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
            long r2 = (long) r * r;
            if (cache[i] == null) cache[i] = new Bomb(i);
            Bomb bomb = cache[i];
            for (int j = 0; j < length; j++) {
                if (i == j) continue;
                int a = bombs[j][0], b = bombs[j][1];
                if ((long) (x - a) * (x - a) + (long) (y - b) * (y - b) <= r2) {
                    if (cache[j] == null) cache[j] = new Bomb(j);
                    bomb.detonated.add(cache[j]);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            Queue<Bomb> queue = new LinkedList<>();
            boolean[] detonated = new boolean[length];
            queue.add(cache[i]);
            detonated[i] = true;
            int cur = 1;
            while (!queue.isEmpty()) {
                Bomb bomb = queue.poll();
                for (Bomb b : bomb.detonated) {
                    if (detonated[b.i]) continue;
                    queue.add(b);
                    detonated[b.i] = true;
                    cur++;
                }
            }
            if (cur > result) result = cur;
        }
        return result;
    }
}
