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
    public class ListNode {
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
}
