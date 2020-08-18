package com.eesilife.lib;

import java.util.List;

/**
 * Create by siy on 20-8-18
 **/
class L0021_merge_two_sorted_lists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode dump = new ListNode(-1);
        dump.next = l1;
        ListNode pre = dump;
        ListNode tmp;
        while (l1 != null && l2 != null) {
            int n1 = l1.val;
            int n2 = l2.val;
            if (n1 >= n2) {
                tmp = new ListNode(l2.val);
                pre.next = tmp;
                pre = tmp;
                l2 = l2.next;
            } else {
                tmp = new ListNode(l1.val);
                pre.next = tmp;
                pre = tmp;
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            tmp = new ListNode(l1.val);
            pre.next = tmp;
            pre = tmp;
            l1 = l1.next;
        }
        while (l2 != null) {
            tmp = new ListNode(l2.val);
            pre.next = tmp;
            pre = tmp;
            l2 = l2.next;
        }
        return dump.next;
    }

    public static ListNode m2(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode dump = new ListNode(-1);
        dump.next = l1;
        ListNode pre = dump;
        ListNode tmp;
        boolean a1, a2;
        while (l1 != null || l2 != null) {
            a1 = null != l1 ? true : false;
            a2 = null != l2 ? true : false;
            int n1 = 0, n2 = 0;
            if (null != l1) {
                n1 = l1.val;
            }
            if (null != l2) {
                n2 = l2.val;
            }
            if (a1 && a2) {
                if (n1 >= n2) {
                    tmp = new ListNode(l2.val);
                    pre.next = tmp;
                    pre = tmp;
                    l2 = l2.next;
                } else {
                    tmp = new ListNode(l1.val);
                    pre.next = tmp;
                    pre = tmp;
                    l1 = l1.next;
                }
            } else if (a1) {
                tmp = new ListNode(l1.val);
                pre.next = tmp;
                pre = tmp;
                l1 = l1.next;
            } else {
                tmp = new ListNode(l2.val);
                pre.next = tmp;
                pre = tmp;
                l2 = l2.next;
            }
        }
        return dump.next;
    }

    private static ListNode m3(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4};
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                cur.val = arr[i];
            } else {
                ListNode tmp = new ListNode(arr[i]);
                cur.next = tmp;
                cur = tmp;
            }
        }
        int[] arr1 = new int[]{1, 3, 4};
        ListNode head1 = new ListNode(-1);
        ListNode cur1 = head1;
        for (int j = 0; j < arr1.length; j++) {
            if (j == 0) {
                cur1.val = arr1[j];
            } else {
                ListNode tmp = new ListNode(arr1[j]);
                cur1.next = tmp;
                cur1 = tmp;
            }
        }
        mergeTwoLists(head, head1);
    }
}
