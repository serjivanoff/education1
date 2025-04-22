package com.education.algos.leetcode.dynamic;

import java.util.Arrays;
import java.util.Comparator;

public class BuySellStock {
    public static void main(String[] args) {
        System.out.println(new BuySellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BuySellStock().maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
    }

    public int maxProfit(int[] prices) {
        int min = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cur = prices[i] - min;
            if (cur > profit) {
                profit = cur;
                continue;
            }
            if (cur < 0) {
                min = prices[i];
            }
        }
        return profit;
    }

    public int maxProfit1(int[] prices) {
        class Node {
            final int price;
            final int day;

            Node(int price, int pos) {
                this.price = price;
                this.day = pos;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "price=" + price +
                        ", day=" + day +
                        '}';
            }
        }
        Node[] nodes = new Node[prices.length];
        for (int i = 0; i < prices.length; i++) {
            nodes[i] = new Node(prices[i], i);
        }
        Arrays.sort(nodes, Comparator.comparingInt(n -> n.price));
        Node buy = nodes[0], sell = nodes[nodes.length - 1];
        if (buy.day < sell.day) {
            return sell.price - buy.price;
        }
        return 0;
    }
}
