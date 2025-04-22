package com.education.algos.leetcode;

public class TimeNeededBuyTickets {
    public static void main(String[] args) {

    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int ticket = tickets[k], time = 0;
        for (int i = 0; i <= k; i++) {
            time += Math.min(tickets[i], ticket);
        }
        for (int i = k + 1; i < tickets.length; i++) {
            time += tickets[i] < ticket ? tickets[i] : ticket - 1;
        }
        return time;
    }
}
