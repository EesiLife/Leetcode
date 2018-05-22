package com.eesilife.lib;

/**
 * Created by siy on 18-5-22.
 */
public class L002_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode mListNode = new ListNode(0);
            int m = 0;
            ListNode l3 = mListNode;
            while (null != l1 || null != l2) {
                if (null != l1) {
                    m += l1.val;
                    l1 = l1.next;
                }
                if (null != l2) {
                    m += l2.val;
                    l2 = l2.next;
                }
                l3.next = new ListNode(m % 10);
                l3 = l3.next;
                m /= 10;
            }
            if (m == 1) {
                l3.next = new ListNode(1);
            }
            return mListNode.next;

        }
    }

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * @param args
     */
    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        l1.next = l11;
        l11.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        l2.next = l21;
        l21.next = new ListNode(4);

        String s = "";
        ListNode result = ListNode.addTwoNumbers(l1, l2);
        while (result != null){
            int a = result.val;
            s += String.valueOf(a);
            result = result.next;
        }
        System.out.println(s);
    }
}