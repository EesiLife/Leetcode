package com.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Create by siy on 20-8-28
 **/
class Te {

    public static boolean judgeCircle(String moves) {
        if (null == moves || "".equals(moves)) return true;
        int ans = 0;
        int len = moves.length();
        for (int i = 0; i < len; i++) {
            char tmp = moves.charAt(i);
            switch (tmp) {
                case 'R':
                    ans++;
                    break;
                case 'L':
                    ans--;
                    break;
                case 'U':
                    ans += 2;
                    break;
                case 'D':
                    ans -= 2;
                    break;
                default:
                    break;
            }
        }
        return ans == 0;
    }

    public static int calculate(String s) {
        if (null == s || s.equals("")) return 0;
        s = s.replaceAll(" ", "");
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        char op = '+';
        int n = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0');
            }
            if (!Character.isDigit(c) || i == len - 1) {
                switch (op) {
                    case '+':
                        stack.push(n);
                        break;
                    case '-':
                        stack.push(-n);
                        break;
                    case '*':
                        stack.push(stack.pop() * n);
                        break;
                    case '/':
                        stack.push(stack.pop() / n);
                        break;
                }
                n = 0;
                op = c;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        str = str.substring(1, str.length() - 1);
        System.out.println(str);
        return str.indexOf(s) != -1;
    }

    public static boolean repeatedSubstringPattern1(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = head;
        while (head != null) {
            int val = head.val;
            if (list.contains(val)) {
                pre.next = head.next;
                head = pre.next;
                pre = pre.next;
            } else {
                list.add(val);
            }
        }
        return dump.next;
    }


    public static String reverseLeftWords(String s, int n) {
        String s1 = s.substring(0, n);
        System.out.println(s1 + "\n");
        String s2 = s.substring(n);
        System.out.println(s2 + "\n");
        return s2 + s1;
    }

    public static String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (Character c : S.toCharArray()) {
            switch (c) {
                case '(':
                    if (flag > 0) {
                        sb.append('(');
                    }
                    flag++;
                    break;
                case ')':
                    flag--;
                    if (flag > 0) {
                        sb.append(')');
                    }
                    break;
                default:
                    break;
            }
        }
        return sb.toString();
    }

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer val : arr) {
            Integer tmp = map.get(val);
            if (null != tmp) {
                map.put(val, tmp + 1);
            } else {
                map.put(val, 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        boolean ans = true;
        for (Integer val : map.values()) {
            if (list.contains(val)) {
                ans = false;
                break;
            } else {
                list.add(val);
            }
        }
        return ans;
    }

    public static String sortChars(String str) {
        char[] a = str.toCharArray();
        Arrays.sort(a);
        String rs = new String(a);
        return rs;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = sortChars(s);
            if (map.containsKey(key)) {
                List<String> tmp = map.get(key);
                tmp.add(s);
                map.put(key, tmp);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> list : map.values()) {
            ans.add(list);
        }
        return ans;
    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Math.abs(o1) - Math.abs(o2);
        }
    }


    public static boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer val : A) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        Integer[] B = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }
        Comparator cmp = new MyComparator();
        Arrays.sort(B, cmp);
        boolean ans = true;
        for (int x : B) {
            if (map.get(x) == 0) continue;
            if (map.get(2 * x) == null || map.get(2 * x) <= 0) {
                ans = false;
                break;
            }
            map.put(x, map.get(x) - 1);
            map.put(2 * x, map.get(2 * x) - 1);
        }
        return ans;
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        if (null == nums || nums.length == 0) return nums;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] B = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            B[i] = nums[i];
        }
        Arrays.sort(B);
        int last = B[0];
        for (int i = 0; i < B.length; i++) {
            int cur = B[i];
            if (cur > last) {
                last = cur;
                map.put(cur, i);
            }
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = map.getOrDefault(nums[i], 0);
        }
        return ans;
    }

    public static int[] smallerNumbersThanCurrent1(int[] nums) {
        // 统计出现频率 frequency
        int[] freq = new int[101]; // 索引即数值
        for (int num : nums) freq[num]++;

        // 频率累加 得到比自己小的元素数量 也即是自己的排名 而且后一项的排名可以从前一项递推得到
        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i] + freq[i - 1];
        }

        // 输出结果
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            if (nums[i] > 0) res[i] = freq[nums[i] - 1];
            else res[i] = 0;
        }
        return res;
    }


    public static int islandPerimeter(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (1 == grid[i][j]) {
                    int lines = 4;
                    //判断这个岛旁边连接了多少个岛
                    if (i > 0 && grid[i - 1][j] == 1) lines--;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) lines--;
                    if (j > 0 && grid[i][j - 1] == 1) lines--;
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) lines--;
                    ans += lines;
                }
            }
        }
        return ans;
    }

    public static boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = nums[i];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] + (-dp[i + 1][j]), nums[j] + (-dp[i][j - 1]));
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public static boolean PredictTheWinner1(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = nums[i];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] + (-dp[i + 1][j]), nums[j] + (-dp[i][j - 1]));
            }
        }
        return dp[0][n - 1] >= 0;
    }


    public static int massage(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    public int massage1(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }

    public int rob(int[] nums) {
        int cur = 0, pre = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = Math.max(cur, pre + nums[i]);
            pre = cur;
            cur = tmp;
        }
        return cur;
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                ans++;
            }
        }
        return ans;
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        int ans = -1;
        String[] arr = sentence.split(" ");
        int len = searchWord.length();
        for (int i = 0; i < arr.length; i++) {
            String cur = arr[i];
            if (cur.length() < len) continue;
            if (cur.substring(0, len).equals(searchWord)) {
                ans = i + 1;
                break;
            }
        }
        return ans;
    }

    public static int minCostClimbingStairs(int[] cost) {
        if (null == cost) return 0;
        if (cost.length == 1) return cost[0];
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }

    public static int minCostClimbingStairs1(int[] cost) {
        int len = cost.length;
        if (null == cost) return 0;
        if (cost.length == 1) return cost[0];
        int[] dp = new int[len];
        if (len == 2) {
            dp[1] = Math.min(cost[0], cost[1]);
        } else if (len == 3) {
            dp[2] = Math.min(cost[1], cost[1] + cost[0]);
        } else {
            dp[0] = cost[0];
            dp[1] = Math.min(cost[1], cost[0]);
            dp[2] = Math.min(cost[1], cost[2] + cost[0]);
            for (int i = 4; i <= len; i++) {
                dp[i - 1] = Math.min(dp[i - 2] + cost[i - 1], dp[i - 3] + cost[i - 2]);
            }
        }
        return dp[len - 1];

    }

    public static String longestPalindrome(String s) {
        int maxLen = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String s1 = getCurrent(s, i, i);
            String s2 = getCurrent(s, i, i + 1);
            String maxStr = s1.length() > s2.length() ? s1 : s2;
            if (maxStr.length() > maxLen) {
                res = maxStr;
                maxLen = maxStr.length();
            }
        }
        return res;
    }

    public static String getCurrent(String s, int i, int j) {
        int len = s.length();
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substring(i + 1, j);
    }


    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim();
        boolean isDot = false;
        boolean isE = false;
        boolean isNum = false;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                isNum = true;
            } else if (c == '.') {
                if (isDot || isE) return false;
                isDot = true;
            } else if (c == 'e' || c == 'E') {
                if (!isNum || isE) return false;
                isE = true;
                isNum = false;
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else {
                return false;
            }
        }
        return isNum;
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static int maxSubArray1(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }

    public static int waysToStep(int n) {
        long[] dp = new long[n];
        if (n > 0) {
            dp[0] = 1;
        }
        if (n > 1) {
            dp[1] = 2;
        }
        if (n > 2) {
            dp[2] = 4;
        }
        for (int i = 4; i <= n; i++) {
            dp[i - 1] = (dp[i - 2] + dp[i - 3] + dp[i - 4]) % 1000000007;
        }
        return (int) dp[n - 1];
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] count = countZeroOne(s);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(1 + dp[i - count[0]][j - count[1]], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static int[] countZeroOne(String s) {
        int[] ans = new int[2];
        for (char c : s.toCharArray()) {
            ans[c - '0']++;
        }
        return ans;
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (nums[i] <= 0) nums[i] = N + 1;
        }
        for (int i = 0; i < N; i++) {
            int cur = Math.abs(nums[i]);
            if (cur <= N) {
                nums[cur - 1] = -Math.abs(nums[cur - 1]);
            }
        }
        for (int i = 0; i < N; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return N + 1;
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < len; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    class MyQueue {

        /**
         * Initialize your data structure here.
         */
        Stack<Integer> s1;
        Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            s1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            int ans = -1;
            while (!s1.empty()) {
                ans = s1.pop();
                if (!s1.empty()) {
                    s2.push(ans);
                }
            }
            while (!s2.empty()) {
                s1.push(s2.pop());
            }
            return ans;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            int ans = -1;
            while (!s1.empty()) {
                ans = s1.pop();
                s2.push(ans);
            }
            while (!s2.empty()) {
                s1.push(s2.pop());
            }
            return ans;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return s1.size() == 0;
        }
    }

    class CQueue {
        Stack<Integer> main;
        Stack<Integer> temp;

        public CQueue() {
            main = new Stack<>();
            temp = new Stack<>();
        }

        public void appendTail(int value) {
            main.push(value);
        }

        public int deleteHead() {
            int element = -1;
            if (temp.isEmpty()) {
                while (!main.isEmpty()) {
                    temp.push(main.pop());
                }
            }
            if (!temp.isEmpty()) {
                element = temp.pop();
            }
            return element;
        }
    }

    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('0');
        for (Character c : s.toCharArray()) {
            Character tmp = stack.peek();
            if (Math.abs(c - tmp) == 32) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() != 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString().substring(1);
    }

    static class MinStack1 {

        /**
         * initialize your data structure here.
         */
        Stack<Integer> mainStack;
        Stack<Integer> minStack;
        int size;
        int min;

        public MinStack1() {
            mainStack = new Stack<>();
            minStack = new Stack<>();
            size = 0;
            min = -1;
        }

        public void push(int x) {
            size++;
            mainStack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
                min = x;
            } else {
                if (min >= x) {
                    minStack.push(x);
                    min = x;
                }
            }
        }

        public void pop() {
            if (size > 0) {
                size--;
                int cur = mainStack.pop();
                if (cur == min) {
                    minStack.pop();
                    min = minStack.isEmpty() ? -1 : minStack.peek();
                }
            }
        }

        public int top() {
            return mainStack.isEmpty() ? -1 : mainStack.peek();
        }

        public int getMin() {
            return min;
        }
    }


    class MyQueue1 {

        /**
         * Initialize your data structure here.
         */
        Stack<Integer> mainStack;
        Stack<Integer> helpStack;

        public MyQueue1() {
            mainStack = new Stack<>();
            helpStack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            mainStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (helpStack.isEmpty()) {
                while (!mainStack.isEmpty()) {
                    helpStack.push(mainStack.pop());
                }
            }
            return helpStack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (helpStack.isEmpty()) {
                while (!mainStack.isEmpty()) {
                    helpStack.push(mainStack.pop());
                }
            }
            return helpStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return mainStack.isEmpty() && helpStack.isEmpty();
        }
    }

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (Character c : S.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    class MyStack {


        /**
         * Initialize your data structure here.
         */
        ArrayDeque<Integer> main;

        public MyStack() {
            main = new ArrayDeque<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            main.addLast(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return main.removeLast();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return main.peekLast();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return main.isEmpty();
        }
    }

    public static List<String> buildArray(int[] target, int n) {
        Stack<Integer> stack = new Stack<>();
        List<String> ans = new ArrayList<>();
        int max = 1;
        for (int i = 0; i < target.length; i++) {
            stack.push(target[i]);
        }
        if (null != stack) {
            max = Math.max(stack.peek(), max);
        }
        int[] res = new int[n];
        for (int i = n; i >= 1; i--) {
            if (!stack.isEmpty() && stack.peek() == i) {
                res[i - 1] = 0;
                stack.pop();
            } else {
                res[i - 1] = 1;
            }
        }
        for (int i = 0; i < max; i++) {
            ans.add("Push");
            if (res[i] != 0) {
                ans.add("Pop");
            }
        }
        return ans;
    }

    public static List<String> buildArray1(int[] target, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            if (i < target[j]) {
                list.add("Push");
                list.add("Pop");
            } else if (i == target[j]) {
                j++;
                list.add("Push");
            }
        }
        return list;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int len = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int key = nums2[i];
            int val = getValue(nums2, i + 1, key);
            map.put(key, val);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

    public static int getValue(int[] nums2, int j, int key) {
        int val = -1;
        for (int i = j; i < nums2.length; i++) {
            if (nums2[i] > key) {
                val = nums2[i];
                break;
            }
        }
        return val;
    }

//    public static int longestWPI(int[] hours) {
//
//    }

    public static void main(String[] args) {
        //[1,3,5,2,4]
        //[6,5,4,3,2,1,7]
        int[] n1 = new int[]{1, 3, 5, 2, 4};
        int[] n2 = new int[]{6, 5, 4, 3, 2, 1, 7};
        System.out.println(Arrays.toString(nextGreaterElement1(n1, n2)));
    }

}
