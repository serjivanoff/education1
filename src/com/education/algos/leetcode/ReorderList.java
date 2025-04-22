package com.education.algos.leetcode;

import java.util.Stack;

public class ReorderList {

    public static void main(String[] args) {
        final ReorderList inst = new ReorderList();
        inst.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        inst.reorderList(new ListNode(1));
    }

    public void reorderList(ListNode head) {
        ListNode next = head.next;
        if (next == null) return;
        int count = 0;
        Stack<ListNode> stack = new Stack<>();
        do {
            stack.push(next);
            count++;
        } while ((next = next.next) != null);
        int i = 0;
        next = head;
        while (i < count) {
            ListNode old = next.next;
            next.next = stack.pop();
            next = next.next;
            i++;
            if (i < count) {
                next.next = old;
                next = next.next;
                i++;
            }
        }
        next.next = null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
