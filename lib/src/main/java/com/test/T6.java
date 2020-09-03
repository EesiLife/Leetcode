package com.test;

import java.util.Stack;

public class T6 {
    public static int longestWPI(int[] hours) {
        int len = hours.length;
        int[] score = new int[len];
        for (int i = 0; i < len; i++) {
            if (hours[i] > 8) {
                score[i] = 1;
            } else {
                score[i] = -1;
            }
        }
        int[] preSum = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            preSum[i] = preSum[i - 1] + score[i - 1];
        }
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len + 1; i++) {
            if (stack.isEmpty() || preSum[stack.peek()] > preSum[i]) {
                stack.push(i);
            }
        }
        int i = len;
        while (i > ans) {
            while (!stack.isEmpty() && preSum[stack.peek()] < preSum[i]) {
                ans = Math.max(ans, i - stack.peek());
                stack.pop();
            }
            i--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,9,6,0,6,6,9};
        System.out.println(longestWPI(a));
    }
}
