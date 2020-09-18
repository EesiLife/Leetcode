package com.test;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    public static void main(String[] args) throws NoSuchAlgorithmException {
//
        get("siyu");
    }

    private static void get(String userName) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.reset();
        digest.update(userName.getBytes());
        byte[] bytes = digest.digest();
        String hexstr = toHexString(bytes);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hexstr.length(); i++) {
            sb.append(hexstr.charAt(i));
        }
        String userSN = sb.toString();
        System.out.println(userSN);
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String toHexString(byte... bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);

    }

}
