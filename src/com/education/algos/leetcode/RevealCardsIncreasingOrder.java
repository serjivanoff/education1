package com.education.algos.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsIncreasingOrder {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RevealCardsIncreasingOrder().deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
        System.out.println(Arrays.toString(new RevealCardsIncreasingOrder().deckRevealedIncreasing(new int[]{11,1000})));
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int length = deck.length;
        int[] res = new int[length];
        if (length == 1 || length == 2) return deck;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(deck[length - 1]);
        queue.add(deck[length - 2]);
        for (int i = length - 3; i >= 0; i--) {
            int poll = queue.poll();
            queue.add(poll);
            queue.add(deck[i]);
        }
        for (int i = length - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }
        return res;
    }
}
