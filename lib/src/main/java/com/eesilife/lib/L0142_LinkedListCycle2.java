package com.eesilife.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by siy on 20-8-13
 **/
class L0142_LinkedListCycle2 {


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

    public ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        ListNode ans = null;
        while (head != null) {
            head = head.next;
            if (null != head) {
                if (list.contains(head)) {
                    ans = head;
                    break;
                } else {
                    list.add(head);
                }
            }
        }
        return ans;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        if (l1 != null) {
            ans.next = l1;
        } else if (l2 != null) {
            ans.next = l2;
        }
        int m = 0;
        ListNode pre = ans;
        while (l1 != null || l2 != null) {
            int val = m;
            if (l1 !=  null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            m = val / 10;
            ListNode tmp = new ListNode(val % 10);
            pre.next = tmp;
            pre = tmp;
        }
        if (m != 0) {
            pre.next = new ListNode(m);
        }
        return ans.next;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{3,2,0,-4};
//        ListNode head = new ListNode(-1);
//        ListNode cur = head;
//        int index = -1;
//        ListNode nodeIndex = null;
//        for (int i = 0; i < arr.length; i ++) {
//            if (i == 0) {
//                cur.val = arr[i];
//            } else if (index == i) {
//                ListNode tmp = new ListNode(arr[i]);
//                cur.next = tmp;
//                cur = tmp;
//                nodeIndex = tmp;
//            } else {
//                ListNode tmp = new ListNode(arr[i]);
//                cur.next = tmp;
//                cur = tmp;
//                if (i == arr.length -1) {
//                    tmp.next = nodeIndex;
//                }
//            }
//        }
//
//        boolean ret = hasCycle(head);
//        System.out.println(ret);


        int[] arr = new int[]{1, 8};
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int i = 0; i < arr.length; i ++) {
            if (i == 0) {
                cur.val = arr[i];
            } else {
                ListNode tmp = new ListNode(arr[i]);
                cur.next = tmp;
                cur = tmp;
            }
        }
        int[] arr1 = new int[]{0};
        ListNode head1 = new ListNode(-1);
        ListNode cur1 = head1;
        for (int i = 0; i < arr1.length; i ++) {
            if (i == 0) {
                cur1.val = arr1[i];
            } else {
                ListNode tmp = new ListNode(arr1[i]);
                cur1.next = tmp;
                cur1 = tmp;
            }
        }
        ListNode ans = addTwoNumbers(head, head1);
    }
}
