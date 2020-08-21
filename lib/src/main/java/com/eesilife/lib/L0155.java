package com.eesilife.lib;

import java.util.Arrays;
import java.util.Stack;

public class L0155 {
    class MinStack {

        /**
         * initialize your data structure here.
         */
        Stack<Integer> mStack;
        Stack<Integer> mMinStack;

        public MinStack() {
            mStack = new Stack<>();
            mMinStack = new Stack<>();
        }

        public void push(int x) {
            mStack.add(x);
            if (mMinStack.isEmpty()) {
                mMinStack.add(x);
            } else {
                int top = mMinStack.peek();
                if (x <= top) {
                    mMinStack.add(x);
                }
            }
        }

        public void pop() {
            int pop = mStack.pop();
            int minTop = mMinStack.peek();
            if (pop == minTop) {
                mMinStack.pop();
            }
        }

        public int top() {
            return mStack.peek();
        }

        public int getMin() {
            return mMinStack.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    class MinStack1 {

        /**
         * initialize your data structure here.
         */
        Stack<Integer> mStack;
        int min = Integer.MAX_VALUE;

        public MinStack1() {
            mStack = new Stack<>();
        }

        public void push(int x) {
            if (x <= min) {
                mStack.push(min);
                min = x;
            }
            mStack.push(x);
        }

        public void pop() {
            int pop = mStack.pop();
            if (min == pop) {
                min = mStack.pop();
            }
        }

        public int top() {
            return mStack.peek();
        }

        public int getMin() {
            return min;
        }
    }

    class MinStack2 {

        /**
         * initialize your data structure here.
         */

        class Node {
            int value;
            int min;
            Node next;

            Node(int x, int min) {
                this.value = x;
                this.min = min;
                next = null;
            }
        }

        Node head;

        public MinStack2() {
        }

        public void push(int x) {

            if (null == head) {
                head = new Node(x, x);
            } else {
                Node n = new Node(x, Math.min(x, head.min));
                n.next = head;
                head = n;
            }
        }

        public void pop() {
            if ( null != head) {
                head = head.next;
            }
        }

        public int top() {
            if (null != head) {
                return head.value;
            }
            return -1;
        }

        public int getMin() {
            if (null != head) {
                return head.min;
            }
            return -1;
        }
    }
}
