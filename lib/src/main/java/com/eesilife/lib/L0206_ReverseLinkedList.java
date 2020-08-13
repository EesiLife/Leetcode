package com.eesilife.lib;

/**
 * Create by siy on 20-7-7
 *
 **/

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


public class L0206_ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        //12345->54321
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head) {
        //12345->54321
        if (null == head || head.next == null) {
            return head;
        }
        ListNode cur = reverseList1(head);
        head.next.next = head;
        head.next = null;
        return cur;
    }
    public static void main(String[] args) {
        L0206_ReverseLinkedList l = new L0206_ReverseLinkedList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        ListNode l5 = new ListNode(5);
        l4.next = l5;
        ListNode out = l.reverseList(l1);
    }
}
