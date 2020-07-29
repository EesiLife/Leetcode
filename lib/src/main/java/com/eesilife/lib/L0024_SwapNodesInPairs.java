package com.eesilife.lib;

/**
 * Create by siy on 20-7-8
 **/
public class L0024_SwapNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode swapPairs(ListNode head) {
        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;

    }

    public static ListNode swapPairs1(ListNode head) {
        // 1. 终止条件：当前没有节点或者只有一个节点，肯定就不需要交换了
        if (head == null || head.next == null) return head;

        // 2. 调用单元
        // 需要交换的两个节点是 head 和 head.next
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        // firstNode 连接后面交换完成的子链表
        firstNode.next = swapPairs1(secondNode.next);
        // secondNode 连接 firstNode
        secondNode.next = firstNode;

        // 3. 返回值：返回交换完成的子链表
        // secondNode 变成了头结点
        return secondNode;
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
        ListNode out = swapPairs1(head);
    }
}
