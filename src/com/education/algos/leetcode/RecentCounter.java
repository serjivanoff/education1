package com.education.algos.leetcode;

public class RecentCounter {
    Node head = null;
    Node tail = null;
    int qty = 0;

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
    }

    public RecentCounter() {

    }

    public int ping(int t) {
        if (head == null) {
            head = new Node(t);
            return qty = 1;
        }
        int l = t - 3000;
        if (tail == null) {
            if (head.t < l) {
                head.t = t;
                return qty;
            }
            tail = new Node(t);
            head.next = tail;
            return qty = 2;
        }
        if (l > tail.t) {
            tail = null; head = new Node(t);
            return qty = 1;
        }
        Node current = head;
        while (current.t < l && current.next != null) {
            qty--;
            current = current.next;
        }
        head = current;
        tail.next = new Node(t);
        tail = tail.next;
        return ++qty;
    }

    private static class Node {
        int t;
        Node next;

        public Node(int t) {
            this.t = t;
        }
    }
}
