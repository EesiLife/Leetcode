package com.test;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField;

import sun.security.acl.AclEntryImpl;

public class T7 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode l, TreeNode r) {
            val = x;
            left = l;
            right = r;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (null != root.left) {
            inorderTraversal(root.left);
        }
        sList.add(root.val);

        if (null != root.right) {
            inorderTraversal(root.right);
        }
        return sList;
    }

    private static List<Integer> sList = new ArrayList<>();

    private static TreeNode initNode() {
        TreeNode J = new TreeNode(8, null, null);
        TreeNode H = new TreeNode(4, null, null);
        TreeNode G = new TreeNode(2, null, null);
        TreeNode F = new TreeNode(7, null, J);
        TreeNode E = new TreeNode(5, H, null);
        TreeNode D = new TreeNode(1, null, G);
        TreeNode C = new TreeNode(9, F, null);
        TreeNode B = new TreeNode(3, D, E);
        TreeNode A = new TreeNode(6, B, C);
        return A;
    }

    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (null != root) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
        return res;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        return res;
    }

    public static boolean isValid(String s) {
        if (!s.startsWith("a") || s.length() < 3) return false;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String cur = String.valueOf(s.charAt(i));
            if (stack.isEmpty()) {
                stack.push(cur);
            } else {
                String tmp = stack.peek();
                if (tmp.length() == 1) {
                    if (cur.equals("b")) {
                        stack.pop();
                        stack.push("ab");
                    } else if (cur.equals("a")) {
                        stack.push("a");
                    } else {
                        return false;
                    }
                } else {
                    if (cur.equals("c")) {
                        stack.pop();
                    } else {
                        stack.push(cur);
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid1(String s) {
        if (!s.startsWith("a") || s.length() < 3) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == 'c') {
                checkValid(stack);
            } else {
                stack.push(cur);
            }
        }
        return stack.isEmpty();
    }

    public static boolean checkValid(Stack<Character> stack) {
        if (stack.isEmpty()) return false;
        if (stack.pop() != 'b') return false;
        if (stack.isEmpty()) return false;
        if (stack.pop() != 'a') return false;
        return true;
    }

    public static boolean isValid2(String s) {
//        if (!s.startsWith("a") || s.length() < 3) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') return false;
                if (stack.isEmpty() || stack.pop() != 'a') return false;
            } else {
                stack.push(cur);
            }
        }
        return stack.isEmpty();
    }

    public static boolean find132pattern(int[] nums) {
        if (null == nums || nums.length < 3) return false;
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        int minLeft = nums[maxIndex];
        for (int i = 0; i < nums.length; i++) {
            if (i < maxIndex) {
                if (nums[i] < minLeft) {
                    minLeft = nums[i];
                }
            } else if (i > maxIndex) {
                if (nums[i] > minLeft && nums[i] < max) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean find132pattern1(int[] nums) {
        if (nums.length < 3) return false;
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }

//    public static void main(String[] args) {
////        int[] a = new int[]{1, 0, 1, -4, -3};
////        int[] a = new int[]{3, 5, 0, 3, 4};
////        int[] a = new int[]{-2, 1, 1};
//        int[] a = new int[]{1, 4, 0, -1, -2, -3, -1, -2};
//        System.out.println(find132pattern(a));
//    }

    public static int[][] transpose(int[][] A) {
        int len = A.length;
        int w = A[0].length;
        int[][] ans = new int[w][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < w; j++) {
                ans[j][i] = A[i][j];
                System.out.println(A[j][i]);
            }
        }
        return ans;
    }

    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int half = len / 2;
        for (int i = 0; i < nums.length; i++) {
            int size = map.getOrDefault(nums[i], 0);
            if (++size > half) return nums[i];
            map.put(nums[i], size);
        }
        return -1;
    }

    public int majorityElement(int[] nums) {
        int len = nums.length;
        int half = len / 2;
        int count = 0;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                cur = nums[i];
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == cur) count++;
            if (count > half) return cur;
        }
        return -1;
    }

    public int[] sortedSquares1(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int i = 0, j = len - 1, k = len - 1;
        int[] ans = new int[len];
        while (i <= j) {
            if (A[i] + A[j] < 0) {
                ans[k--] = A[i] * A[i];
                i++;
            } else {
                ans[k--] = A[j] * A[j];
                j--;
            }
        }
        return ans;
    }

    public int maximumProduct1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 3] * nums[len - 2] * nums[len - 1]);
    }

    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if (tmp < min1) {
                min2 = min1;
                min1 = tmp;
            } else if (tmp < min2) {
                min2 = tmp;
            }


            if (tmp > max3) {
                max1 = max2;
                max2 = max3;
                max3 = tmp;
            } else if (tmp > max2) {
                max1 = max2;
                max2 = tmp;
            } else if (tmp > max1) {
                max1 = tmp;
            }

        }
        return Math.max(min1 * min2 * max3, max1 * max2 * max3);
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                count++;
                if (count == 3) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int j = (i + k) > nums.length ? (nums.length - 1) : i + k;
            while (j < nums.length && j > i) {
                if (nums[j] == nums[i]) {
                    return true;
                }
                j--;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.contains(nums[i])) {
                return true;
            }
            map.add(nums[i]);
            if (map.size() > k) {
                map.remove(nums[k - i]);
            }
        }
        return false;
    }

    public static int[] exchange(int[] nums) {
        if (null == nums || nums.length == 1) return nums;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] % 2 == 0) {
                if (nums[r] % 2 != 0) {
                    int tmp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = tmp;
                    l++;
                }
                r--;
            } else {
                l++;
                if (nums[r] % 2 == 0) {
                    r--;
                }
            }
        }
        return nums;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode f = head;
        ListNode la = head;
        int i = 0;
        while (f != null) {
            f = f.next;
            i++;
            if (i > k) {
                la = la.next;
            }
        }
        return la;
    }


    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode tmp = ans.next;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l1 != null ? l1 : l2.next;
        return ans.next;
    }

//    public static void main(String[] args) {
//        ListNode l = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        l.next = l2;
//        ListNode l3 = new ListNode(3);
//        l2.next = l3;
//        ListNode l4 = new ListNode(4);
//        l3.next = l4;
//        ListNode l5 = new ListNode(5);
//        l4.next = l5;
//        ListNode l6 = new ListNode(6);
//        l5.next = l6;
//        reverseList(l);
//    }

//    public List<Integer> spiralOrder(int[][] matrix) {
//        int r = matrix.length;
//        int c = matrix[0].length;
//    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int len = arr.length;
        int ans = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    boolean r1 = Math.abs(arr[i] - arr[j]) >= a;
                    boolean r2 = Math.abs(arr[j] - arr[k]) >= b;
                    boolean r3 = Math.abs(arr[i] - arr[k]) >= c;
                    if (r1 && r2 && r3) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

//    public static void main(String[] args) {
//        String a = "abc";
//        T7 t = new T7();
//        t.permutation(a);
//    }

//    public static int cuttingRope(int n) {
//        int p = (int)Math.sqrt(n);
//        int q = p + 1;
//        int r = n - (int)Math.pow(p, 2);
//
//        System.out.println("6^8:"  + Math.pow(6, 6) * 3 + ";55:" + Math.pow(6, 3) *7 * 7 * 7);
//        return p;
//    }

    public static int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        if (n == 4) return 4;
        long res = 1;
        while (n > 4) {
            n -= 3;
            res *= 3;
        }
        return (int) ((res * n) % 1000000007);
    }

    public static int majorityElement2(int[] nums) {
        int count = 1;
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ans) {
                count++;
            } else {
                if (--count == 0) {
                    count = 1;
                    ans = nums[i];
                }
            }
        }
        for (int num : nums) {
            if (num == ans) count++;
        }
        if (count > nums.length / 2) {
            return ans;
        }
        return -1;
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                queue.add(arr[i]);
            } else {
                if (queue.peek() > arr[i]) {
                    queue.remove();
                    queue.add(arr[i]);
                }
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.remove();
        }
        return ans;
    }

    public int countDigitOne(int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String val = String.valueOf(i);
            char[] arr = val.toCharArray();
            for (int j = 0; i < arr.length; i++) {
                if (arr[i] == '1') ans++;
            }
        }
        return ans;
    }

//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        Stack<Integer> sa = new Stack<>();
//        Stack<Integer> sb = new Stack<>();
//        while (headA != null) {
//            sa.push(headA.val);
//            headA = headA.next;
//        }
//        while (headB != null) {
//            sb.push(headB.val);
//            headB = headB.next;
//        }
//    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = left + (right - left) / 2;
        int ans = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                break;
            }
        }
        int i = mid - 1, j = mid;
        while (i >= 0) {
            if (nums[i] == target) ans++;
            i--;
        }
        while (j < nums.length) {
            if (nums[j] == target) ans++;
            j++;
        }
        return ans;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) i++;
            else if (sum > target) j--;
            else {
                ans[0] = nums[i];
                ans[1] = nums[j];
                break;
            }
        }
        return ans;
    }

    public static int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums)
            ret ^= n;
        int div = 1;
        while ((div & ret) == 0)
            div <<= 1;
        int a = 0, b = 0;
        for (int n : nums)
            if ((div & n) != 0)
                a ^= n;
            else
                b ^= n;
        return new int[]{a, b};
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static int[][] findContinuousSequence(int target) {

        List<int[]> result = new ArrayList<>();
        int i = 1;

        while (target > 0) {
            target -= i++;
            if (target > 0 && target % i == 0) {
                int[] array = new int[i];
                for (int k = target / i, j = 0; k < target / i + i; k++, j++) {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }

    public static int[][] findContinuousSequence1(int target) {

        List<int[]> result = new ArrayList<>();
        int mid = (target - 1) / 2;
        for (int x = 1; x <= mid; x++) {
            long delta = 1 - 4L * (x - 1L * x * x - 2 * target);
            if (delta < 0) continue;
            long delaSqrt = (long) Math.sqrt((double) delta);
            if (delaSqrt * delaSqrt == delta && (delaSqrt - 1) % 2 == 0) {
                int y = ((int) delaSqrt - 1) / 2;
                if (y <= x) continue;
                int[] a = new int[y - x + 1];
                for (int i = x; i <= y; i++) {
                    a[i - x] = i;
                }
                result.add(a);
            }

        }
        return result.toArray(new int[0][]);
    }

    public static int[][] findContinuousSequence3(int target) {

        List<int[]> result = new ArrayList<>();
        for (int l = 1, r = 2; l < r; ) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] a = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    a[i - l] = i;
                }
                result.add(a);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return result.toArray(new int[0][]);
    }

    public static String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (null == arr[i] || "".equals(arr[i])) continue;
            sb.append(arr[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

//    class MaxQueue {
//
//        public MaxQueue() {
//
//        }
//
//        public int max_value() {
//
//        }
//
//        public void push_back(int value) {
//
//        }
//
//        public int pop_front() {
//
//        }
//    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            ans[i - k + 1] = deque.peekFirst();
        }
        return ans;
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        if (null == arr || arr.length == 0) return 0;
        int left = 0, right = arr.length - 1, len = arr.length;
        while (left + 1 < len && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == arr.length - 1) return 0;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        if (right == 1) return arr.length - 1;
        int ans = Math.min(arr.length - left - 1, right);
        int i = 0, j = right;
        while (i <= left && j < arr.length) {
            if (arr[i] <= arr[j]) {
                ans = Math.min(ans, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

    public static int[] arrayRankTransform(int[] arr) {
        int[] tmp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tmp);
        int j = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tmp.length; i++) {
            Integer cur = map.get(tmp[i]);
            if (null == cur) {
                map.put(tmp[i], j++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    public static int countCharacters(String[] words, String chars) {
        int ans = 0;
        HashMap<Character, Integer> mapChars = new HashMap<>();
        for (char c : chars.toCharArray()) {
            int i = mapChars.getOrDefault(c, 0);
            mapChars.put(c, ++i);
        }
        for (int i = 0; i < words.length; i++) {
            HashMap<Character, Integer> mapWord = new HashMap<>();
            char[] arr = words[i].toCharArray();
            for (char c : arr) {
                int count = mapWord.getOrDefault(c, 0);
                mapWord.put(c, ++count);
            }
            boolean isAns = true;
            for (int j = 0; j < arr.length; j++) {
                if (mapWord.get(arr[j]) > mapChars.getOrDefault(arr[j], 0)) {
                    isAns = false;
                    break;
                }
            }
            if (isAns) {
                ans += words[i].length();
            }
        }
        return ans;
    }

    private static boolean isValid(String src, String chars) {
        for (int i = 0; i < src.length(); i++) {
            if (!chars.contains(String.valueOf(src.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static int maxTurbulenceSize(int[] A) {
        int len = A.length;
        int ans = 0;
        int index = 0;
        for (int i = 1; i < len; i++) {
            int c = Integer.compare(A[i - 1], A[i]);
            if (i == len - 1 || c * Integer.compare(A[i], A[i + 1]) != -1) {
                if (c != 0) ans = Math.max(i - index + 1, ans);
                index = i;
            }
        }
        return ans;
    }

//    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//
//    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                ans.add(Arrays.asList(1));
            } else if (i == 2) {
                ans.add(Arrays.asList(1, 1));
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(1);
                for (int j = 0; j < ans.get(i - 2).size() - 1; j++) {
                    l.add(ans.get(i - 2).get(j) + ans.get(i - 2).get(j + 1));
                }
                l.add(1);
                ans.add(l);
            }
        }
        return ans;
    }

    public static String[] findOcurrences(String text, String first, String second) {
        String[] arr = text.split(" ");
        int len = arr.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            if (arr[i].equals(first) && arr[i + 1].equals(second)) {
                list.add(arr[i + 2]);
                i = i + 1;
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

//    public static int findString(String[] words, String s) {
//        int i = 0, r = words.length - 1;
//        while (i < words.length - 1 && words[i].length() == 0) {
//            i++;
//        }
//        while (r >= 0 && words[r].length() == 0) {
//            r++;
//        }
//        while (i <= r) {
//            int mid = (r + i) / 2;
//            if (words[mid].length() == 0) {
//                i =
//            }
//        }
//    }


//    public static void main(String[] args) throws NoSuchAlgorithmException {
////
//        get("siyu");
//    }
//
//    private static void get(String userName) throws NoSuchAlgorithmException {
//        MessageDigest digest = MessageDigest.getInstance("MD5");
//        digest.reset();
//        digest.update(userName.getBytes());
//        byte[] bytes = digest.digest();
//        String hexstr = toHexString(bytes);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < hexstr.length(); i++) {
//            sb.append(hexstr.charAt(i));
//        }
//        String userSN = sb.toString();
//        System.out.println(userSN);
//    }
//
//    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
//
//    public static String toHexString(byte... bytes) {
//        char[] hexChars = new char[bytes.length * 2];
//        for (int j = 0; j < bytes.length; j++) {
//            int v = bytes[j] & 0xFF;
//            hexChars[j * 2] = hexArray[v >>> 4];
//            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
//        }
//        return new String(hexChars);
//
//    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            int n1 = nums1[i];
            int n2 = nums2[j];
            if (n1 == n2) {
                i++;
                j++;
                list.add(n1);
            } else if (n1 > n2) {
                j++;
            } else {
                i++;
            }
        }
        int[] ans = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ans[k] = list.get(k);
        }
        return ans;
    }

    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] arr = new int[nums.length + 1];
        for (int n : nums) {
            arr[n]++;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                res[1] = i;
            }
            if (arr[i] == 2) {
                res[0] = i;
            }
        }
        return res;

    }

    public int arrangeCoins(int n) {
        int l = 0, r = n;
        long mid, sum;
        while (l <= r) {
            mid = l + (r - l) / 2;
            sum = mid * (mid + 1) / 2;
            if (sum == n) {
                return (int) mid;
            } else if (n > sum) {
                l = (int) mid + 1;
            } else {
                r = (int) mid - 1;
            }
        }
        return r;
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length;
        int mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (letters[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return letters[l % letters.length];
    }

//    public static void main(String[] args) {
//        char[] aa = new char[]{'c', 'f', 'j'};
//        char target = 'j';
//        System.out.println(nextGreatestLetter(aa, target));
//    }

    public int peakIndexInMountainArray1(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid + 1] > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        Arrays.sort(heaters);
        int len = heaters.length;
        for (int house : houses) {
            int left = 0, right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (house > heaters[mid]) left = mid + 1;
                else right = mid;
            }
            int dist1 = (right == 0) ? Integer.MAX_VALUE : Math.abs(house - heaters[right - 1]);
            int dist2 = (right == len) ? Integer.MAX_VALUE : Math.abs(house - heaters[right]);
            res = Math.max(res, Math.min(dist1, dist2));

        }
        return res;
    }

    private static int target = 6;

    public static int guess(int num) {
        if (num == target) return 0;
        if (num > target) return -1;
        else return 1;
    }

    public static int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) == 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) break;
            int L = i + 1, R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int L = j + 1, R = len - 1;
                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        while (L < R && nums[L] == nums[L + 1]) L++;
                        while (L < R && nums[R] == nums[R - 1]) R--;
                        L++;
                        R--;
                    } else if (sum < target) {
                        L++;
                    } else {
                        R--;
                    }
                }
            }
        }
        return ans;
    }

    public static int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        int ans = target;
        int tmp = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1, R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum < target) {
                    break;
                } else {

                }
                if (sum == target) {
                    ans = target;
                    break;
                } else if (sum > target) {
                    R--;
                } else {
                    L++;
                }

            }
        }
        return ans;
    }

    public int threeSumSmaller1(int[] nums, int target) {
        int ans = 0;
        int len = nums.length;
        int left, right;
        Arrays.sort(nums);
        for (int i = 0; i < len; ++i) {
            left = i + 1;
            right = len - 1;
            while (left < right) {
                int three = nums[left] + nums[right] + nums[i];
                if (three >= target) {
                    right--;
                } else {
                    ans += right - left;
                    left++;
                }
            }
        }
        return ans;
    }


//    public static void main(String[] args) {
//        int[] arr = new int[]{-2, 0, 1, 3};
//        System.out.println(threeSumSmaller(arr, 2));
//    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = target;
        int tmp = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1, R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                int gap = Math.abs(sum - target);
                if (tmp > gap) {
                    tmp = gap;
                    ans = sum;
                }
                if (sum == target) {
                    ans = target;
                    break;
                } else if (sum > target) {
                    R--;
                } else {
                    L++;
                }

            }
        }
        return ans;
    }

    public static String modifyString(String s) {
        char[] arr = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char cur = arr[i];
            if (cur == '?') {
                if (i == 0) {
                    cur = 'a';
                    if (i + 1 < arr.length && arr[i + 1] == cur) {
                        cur += 1;
                    }
                } else if (i == arr.length - 1) {
                    cur = 'a';
                    if (i - 1 >= 0 && arr[i - 1] == cur) {
                        cur += 1;
                    }
                } else {
                    cur = 'a';
                    while (cur == arr[i - 1] || cur == arr[i + 1]) {
                        cur += 1;
                    }
                }
            }
            arr[i] = cur;
            ans.append(cur);
        }
        return ans.toString();
    }

    public static String mS(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                char ahead = i == 0 ? ' ' : chars[i - 1];
                char behind = i == chars.length - 1 ? ' ' : chars[i + 1];
                char temp = 'a';
                while (temp == ahead || temp == behind) {
                    temp++;
                }
                //找到目标字符后 做替换
                chars[i] = temp;
            }
        }
        return new String(chars);

    }

    public static String sortString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        while (ans.length() < s.length()) {
            for (int i = 0; i <= 25; i++) {
                if (count[i] > 0) {
                    count[i]--;
                    ans.append((char) (i + 97));
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    ans.append((char) (i + 97));
                    count[i]--;
                }
            }
        }
        return ans.toString();
    }

    public static String generateTheString(int n) {
        StringBuilder ans = new StringBuilder();
        int t1 = 1;
        int t2 = n - t1;
        int t3 = 0;
        if (t2 > 0 && t2 % 2 == 0) {
            t2 = t2 - 1;
            t3 = 1;
        }
        ans.append('a');
        for (int i = 0; i < t2; i++) {
            ans.append('b');
        }
        if (t3 > 0) ans.append('c');
        return ans.toString();
    }

    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() <= 1) return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); i++) {
                count[A.charAt(i) - 'a']++;
            }
            for (int a : count) {
                if (a > 1) return true;
            }
            return false;
        }
        int first = -1, second = -1;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }
        return (second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first));
    }

    public static boolean buddyStrings1(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c : count)
                if (c > 1) return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && A.charAt(first) == B.charAt(second) &&
                    A.charAt(second) == B.charAt(first));
        }
    }

    private static boolean isAlpha(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    public static String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder();
        int j = S.length();
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (isAlpha(cur)) {
                while (j >= 0) {
                    j--;
                    if (isAlpha(S.charAt(j))) {
                        sb.append(S.charAt(j));
                        break;
                    }
                }
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

    public static int maxDepth(String s) {
//        Deque<Character> stack = new LinkedList<>();
//        char[] arr = s.toCharArray();
//        int len = arr.length;
//        if (len == 0) {
//            return 0;
//        }
//        int max = 0;
//        for (char c : arr) {
//            if (c == ')') {
//                stack.pollLast();
//            } else if (c == '(') {
//                stack.offer(c);
//            }
//            max = Math.max(max, stack.size());
//        }
//        return max;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int len = arr.length;
        if (len == 0) {
            return 0;
        }
        int max = 0;
        for (char c : arr) {
            if (c == ')') {
                stack.pop();
            } else if (c == '(') {
                stack.push(c);
            }
            max = Math.max(max, stack.size());
        }
        return max;
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int[] index = new int[26];
        for (int i = 0; i < index.length; i++) {
            index[i] = -1;
        }
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (index[cur - 'a'] != -1) {
                ans = Math.max(i - index[cur - 'a'] - 1, ans);
            } else {
                index[cur - 'a'] = i;
            }
        }
        return ans;
    }

    public static int countSegments(String s) {
        if (s.length() == 0) return 0;
        String[] arr = s.split(" ");
        int ans = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if ("".equals(arr[i])) ans--;
        }
        return ans;
    }


    public static int fx(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) return count[i];
        }
        return 0;
    }

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] qfx = new int[queries.length];
        int[] wfx = new int[words.length];
        for (int i = 0; i < queries.length; i++) {
            qfx[i] = fx(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            wfx[i] = fx(words[i]);
        }
        Arrays.sort(wfx);
        for (int i = 0; i < queries.length; i++) {
            int cur = qfx[i];
            for (int j = 0; j < wfx.length; j++) {
                if (cur < wfx[j]) {
                    ans[i] = wfx.length - j;
                    break;
                }
            }
        }
        return ans;
    }


    public String destCity(List<List<String>> paths) {
        List<String> start = new ArrayList<>();
        List<String> end = new ArrayList<>();
        for (List<String> path : paths) {
            start.add(path.get(0));
            end.add(path.get(1));
        }
        for (String city : start) {
            end.remove(city);
        }
        return end.get(0);
    }


    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] countR = new int[26];
        int[] countM = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            countR[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            countM[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (countR[i] > countM[i]) return false;
        }
        return true;
    }

    public static int balancedStringSplit(String s) {
        if (s.length() <= 1) return 0;
        int ans = 0;
        int countL = 0, countR = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == 'L') {
                if (++countL == countR) {
                    ans++;
                    countL = 0;
                    countR = 0;
                }
            } else {
                if (++countR == countL) {
                    ans++;
                    countL = 0;
                    countR = 0;
                }
            }
        }
        return ans;
    }

    public static int rotatedDigits(int N) {
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            String s = String.valueOf(i);
            int len = s.length();
            int a = 0, b = 0;
            for (int j = 0; j < len; j++) {
                char cur = s.charAt(j);
                if (cur == '2' || cur == '5' || cur == '6' || cur == '9') {
                    a++;
                } else if (cur == '1' || cur == '0' || cur == '8') {
                    b++;
                }
                if (a > 0 && a + b == len) {
                    ans++;
                    System.out.println(s);
                }
            }
        }
        return ans;
    }


    public static List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String w = words[j];
                if (w.contains(word)) {
                    if (!ans.contains(word)) {
                        ans.add(word);
                    }
                }
            }
        }
        return ans;
    }

    public static String reorderSpaces(String text) {
        List<String> list = new ArrayList<>();
        int countSpace = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                countSpace++;
                if (!"".equals(sb.toString())) {
                    list.add(sb.toString());
                }
                sb = new StringBuilder();
            } else {
                sb.append(text.charAt(i));
            }
        }
        if (!"".equals(sb.toString())) {
            list.add(sb.toString());
        }
        int size = list.size();
        int each = size > 1 ? countSpace / (size - 1) : countSpace;
        sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i));
            if (i != size - 1) {
                for (int j = 0; j < each; j++) {
                    sb.append(' ');
                }
                countSpace -= each;
            } else {
                for (int j = 0; j < countSpace; j++) {
                    sb.append(' ');
                }
            }
        }
        return "\"" + sb.toString() + "\"";
    }


    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }

    public static String countAndSay(int n) {
        String[] dp = new String[n + 1];
        dp[1] = "1";
        StringBuilder sb;
        for (int i = 2; i < n + 1; i++) {
            sb = new StringBuilder();
            int count = 0;
            char pre = '0';
            for (char c : dp[i - 1].toCharArray()) {
                if (c != pre) {
                    if (count > 0) {
                        sb.append(count).append(pre);
                    }
                    count = 0;
                    pre = c;
                }
                count++;
            }
            if (count > 0) {
                sb.append(count).append(pre);
            }
            dp[i] = sb.toString();
        }
        return dp[n];
    }

    public static int maxPower(String s) {
        int ans = 0;
        char pre = ' ';
        int count = 0;
        for (char c : s.toCharArray()) {
            if (pre != c) {
                if (count > 0) {
                    ans = Math.max(count, ans);
                }
                pre = c;
                count = 0;
            }
            count++;
        }
        if (count > 0) {
            ans = Math.max(count, ans);
        }
        return ans;
    }

    public static String reverseStr(String s, int k) {
        int len = s.length();
        int step = 2 * k;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i += step) {
            if (len - i < k) {
                sb.append(new StringBuilder().append(s.substring(i)).reverse());
            } else if (len - i < step) {
                sb.append(new StringBuilder().append(s, i, i + k).reverse());
                sb.append(new StringBuilder().append(s.substring(i + k)));
            } else {
                sb.append(new StringBuilder().append(s, i, i + k).reverse());
                sb.append(new StringBuilder().append(s, i + k, i + step));
            }
        }
        return sb.toString();
    }


    public static String toLowerCase(String str) {
        StringBuilder ans = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c - ('A' - 'a'));
            }
            ans.append(c);
        }
        return ans.toString();
    }

    //balloon 0:a; 1:b; 2:n; 3:l; 4:o
    public static int maxNumberOfBalloons1(String text) {
        int[] count = new int[5];
        for (char c : text.toCharArray()) {
            if (c == 'a') {
                count[0]++;
            } else if (c == 'b') {
                count[1]++;
            } else if (c == 'n') {
                count[2]++;
            } else if (c == 'l') {
                count[3]++;
            } else if (c == 'o') {
                count[4]++;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            if (i <= 2) {
                ans = Math.min(count[i], ans);
            } else {
                ans = Math.min(count[i] / 2, ans);
            }
        }
        return ans;
    }

    public static int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 25; i++) {
            if (i == 0 || i == 1 || i == 13) {
                ans = Math.min(count[i], ans);
            } else if (i == 11 || i == 14) {
                ans = Math.min(count[i] / 2, ans);
            }
        }
        return ans;
    }

    public static int countBinarySubstrings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int[] count = new int[len];
        dp[0] = 0;
        count[0] = 1;
        char[] arr = s.toCharArray();
        for (int i = 1; i < len; i++) {
            if (arr[i] != arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                count[i] = 1;
            } else {
                count[i] = count[i - 1] + 1;
                if (i - count[i] >= 0) {
                    if (count[i] <= count[i - count[i]]) {
                        dp[i] = dp[i - 1] + 1;
                    } else {
                        dp[i] = dp[i - 1];
                    }
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[len - 1];
    }

    public static int countBinarySubstrings1(String s) {
        int res = 0;
        int last = 0, count = 1;
        char[] array = s.toCharArray();
        int len = s.length();
        for (int i = 1; i < len; i++) {
            if (array[i] == array[i - 1]) {
                count++;
            } else {
                last = count;
                count = 1;
            }
            if (last >= count) res++;
        }
        return res;
    }

    public static String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        char[] arr = S.toCharArray();
        int count = 0;
        for (char c : arr) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
            if (++count == length) break;
        }
        return sb.toString();
    }

    public static String addStrings1(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add > 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int a = x + y + add;
            if (a >= 10) {
                add = 1;
                a -= 10;
            } else {
                add = 0;
            }
            ans.append(a);
            i--;
            j--;
        }
        return ans.reverse().toString();
    }

    public static String addStrings(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        if (len1 > len2) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < len1 - len2; i++) {
                s.append("0");
            }
            num2 = s.append(num2).toString();
        }
        if (len2 > len1) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < len2 - len1; i++) {
                s.append("0");
            }
            num1 = s.append(num1).toString();
        }
        StringBuilder ans = new StringBuilder();
        int len = Math.max(len1, len2);
        int re = 0;
        for (int i = len - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0' + num2.charAt(i) - '0' + re;
            if (a >= 10) {
                a -= 10;
                re = 1;
            } else {
                re = 0;
            }
            ans.append((char) (a + '0'));
        }
        if (re > 0) {
            ans.append(1);
        }
        return ans.reverse().toString();
    }


    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

//    public static boolean validPalindrome(String s) {
//        StringBuilder sb = new StringBuilder(s);
//        if (sb.reverse().toString().equals(s)) return true;
//        int count = 0;
//    }

    public static boolean checkRecord(String s) {
        int countA = 0;
        boolean late = false;
        char pre = ' ';
        int countL = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                if (++countA > 1) break;
            } else if (c == 'L') {
                if (pre == 'L') {
                    if (++countL > 2) {
                        late = true;
                        break;
                    }
                } else {
                    countL = 1;
                }
            }
            pre = c;
        }
        return !late && countA <= 1;
    }

    public static int getHash(int x, int y) {
        return x * 20001 + y;
    }

    public boolean isPathCrossing(String path) {
        Set<Integer> set = new HashSet<>();
        int x = 0, y = 0;
        set.add(getHash(x, y));
        for (char p : path.toCharArray()) {
            switch (p) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x++;
                    break;
                case 'E':
                    x--;
                    break;
                default:
                    break;
            }
            int hash = getHash(x, y);
            if (set.contains(hash)) {
                return true;
            } else {
                set.add(hash);
            }
        }
        return false;
    }

    public int removePalindromeSub(String s) {
        if ("".equals(s)) return 0;
        if (s.equals(new StringBuilder(s).reverse().toString())) return 1;
        return 2;
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("!", "")
                .replaceAll("\\?", "").replaceAll("'", "")
                .replaceAll(",", "").replaceAll(";", "")
                .replaceAll("\\.", "");
        Map<String, Integer> map = new HashMap<>();
        for (String b : banned) {
            map.put(b, -1);
        }
        String[] aa = paragraph.split(" ");
        for (String a : aa) {
            a = a.replace(" ", "");
            if (!a.equals("")) {
                Integer val = map.get(a);
                if (null == val) {
                    map.put(a, 1);
                } else if (val != -1) {
                    map.put(a, ++val);
                }
            }
        }
        int min = Integer.MIN_VALUE;
        String ans = "";
        for (String key : map.keySet()) {
            int val = map.get(key);
            if (val != -1 && val > min) {
                min = val;
                ans = key;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String name = "Bob hit a ball, the hit BALL flew far after it was hit.", typed = "lleeelee";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(name, banned));
    }
}
