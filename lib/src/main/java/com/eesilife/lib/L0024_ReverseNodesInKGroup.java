package com.eesilife.lib;

/**
 * Create by siy on 20-7-8
 **/
public class L0024_ReverseNodesInKGroup {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump.next;
        int i = 1;
        while (head != null) {
            if (k == i) break;
            ListNode first = head;
            ListNode second = head.next;
            pre.next = second;
            first.next = second.next;
            second.next = first;
            head = first.next;
            i++;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
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
        reverseKGroup(head, 3);
    }

}
