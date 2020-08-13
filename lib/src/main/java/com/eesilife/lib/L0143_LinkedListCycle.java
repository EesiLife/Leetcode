package com.eesilife.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Create by siy on 20-8-13
 **/
class L0143_LinkedListCycle {


    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        boolean ret = false;
        while (head != null) {
            head = head.next;
            if (null != head) {
                if (list.contains(head)) {
                    ret = true;
                    break;
                } else {
                    list.add(head);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,0,-4};
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int index = -1;
        ListNode nodeIndex = null;
        for (int i = 0; i < arr.length; i ++) {
            if (i == 0) {
                cur.val = arr[i];
            } else if (index == i) {
                ListNode tmp = new ListNode(arr[i]);
                cur.next = tmp;
                cur = tmp;
                nodeIndex = tmp;
            } else {
                ListNode tmp = new ListNode(arr[i]);
                cur.next = tmp;
                cur = tmp;
                if (i == arr.length -1) {
                    tmp.next = nodeIndex;
                }
            }
        }

        boolean ret = hasCycle(head);
        System.out.println(ret);
    }
}
