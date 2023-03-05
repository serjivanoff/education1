package com.education.algos.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(20, new ListNode(21, new ListNode(21)))))));
//        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(7, new ListNode(10)))));
//        ListNode list2 = new ListNode(2);
        System.out.println(mergeTwoLists(list1, list2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head = new ListNode(), cur = head;
        while (list1 != null && list2 != null) {
            cur.next = new ListNode();
            cur = cur.next;
            if (list1.val < list2.val) {
                cur.val = list1.val;
                list1 = list1.next;
            } else {
                cur.val = list2.val;
                list2 = list2.next;
            }
        }
        cur.next = list1 == null ? list2 : list1;
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}