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

    public static String mostCommonWord1(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("!", " ")
                .replaceAll("\\?", " ").replaceAll("'", " ")
                .replaceAll(",", " ").replaceAll(";", " ")
                .replaceAll("\\.", " ");
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

    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        Set<String> ban = new HashSet<>();
        for (String b : banned) {
            ban.add(b);
        }
        int maxCount = 0;
        String ans = "";
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                if (sb.length() > 0) {
                    String ss = sb.toString();
                    if (!ban.contains(ss)) {
                        int count = map.getOrDefault(ss, 0);
                        map.put(ss, ++count);
                        if (count > maxCount) {
                            maxCount = count;
                            ans = ss;
                        }
                    }
                }
                sb = new StringBuilder();
            }
        }
        return ans;
    }

    public static String mostCommonWord2(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word : banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String ss : emails) {
            String[] arr = ss.split("@");
            String s = arr[0];
            String last = "@" + arr[1];
            if (s.contains("+")) {
                s = s.substring(0, s.indexOf("+"));
            }
            s = s.replaceAll("\\.", "");
            String email = s + last;
            if (!set.contains(email)) {
                set.add(email);
            }
        }
        return set.size();
    }

    public static int numUniqueEmails1(String[] emails) {
        Set<String> seen = new HashSet();
        for (String email : emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i);
            String rest = email.substring(i);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            local = local.replaceAll("\\.", "");
            seen.add(local + rest);
        }

        return seen.size();
    }

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

    //a e i o u
    private static List<Character> list = Arrays.asList(
            'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
    );

    public static String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (list.contains(c)) {
                stack.push(c);
            }
        }
        for (char c : s.toCharArray()) {
            if (list.contains(c)) {
                sb.append(stack.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String reverseVowels1(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length(), i = 0, j = s.length() - 1;
        while (sb.length() < len) {
            char c = s.charAt(i);
            if (c != 'a' && c == 'e' && c == 'i' && c == 'o' && c == 'u') {
                sb.append(i);
            } else {

            }
        }
        return sb.toString();
    }

    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                low++;
                high--;
            } else {
                boolean flag1 = true, flag2 = true;
                for (int i = low, j = high - 1; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = low + 1, j = high; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }

    public static int maxScore(String s) {
        char[] str = s.toCharArray();
        int N = s.length();
        int l = 0, r = 0;
        if (str[0] == '0') l++;
        int max = l + r;
        for (int i = 1; i < N - 1; i++) {
            if (str[i] == '1') r--;
            else max = Math.max(max, ++l + r);
        }
        if (str[N - 1] == '1') r--;
        return max - r;
    }

    public static void reverseString(char[] s) {
        System.out.println(Arrays.toString(s));
        int i = 0, j = s.length - 1;
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(s));
    }


    public String reformatDate(String date) {
        HashMap<String, String> day = new HashMap<String, String>() {
            {
                put("1st", "1");
                put("2nd", "2");
                put("3rd", "3");
                put("4th", "4");
                put("5th", "5");
                put("6th", "6");
                put("7th", "7");
                put("8th", "8");
                put("9th", "9");
                put("10th", "10");
                put("11th", "11");
                put("12th", "12");
                put("13th", "13");
                put("14th", "14");
                put("15th", "15");
                put("16th", "16");
                put("17th", "17");
                put("18th", "18");
                put("19th", "19");
                put("20th", "20");
                put("21st", "21");
                put("22nd", "22");
                put("23rd", "23");
                put("24th", "24");
                put("25th", "25");
                put("26th", "26");
                put("27th", "27");
                put("28th", "28");
                put("29th", "29");
                put("30th", "30");
                put("31st", "31");
            }
        };
        HashMap<String, String> month = new HashMap<String, String>() {
            {
                put("Jan", "01");
                put("Feb", "02");
                put("Mar", "03");
                put("Apr", "04");
                put("May", "05");
                put("Jun", "06");
                put("Jul", "07");
                put("Aug", "08");
                put("Sep", "09");
                put("Oct", "10");
                put("Nov", "11");
                put("Dec", "12");
            }
        };
        String[] arr = date.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(arr[2]).append("-").append(month.get(arr[1])).append("-").append(day.get(arr[0]));
        return sb.toString();
    }

    public static int numSpecialEquivGroups(String[] A) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String a : A) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < a.length(); i++) {
                if (i % 2 == 0) {
                    sb1.append(a.charAt(i));
                } else {
                    sb2.append(a.charAt(i));
                }
            }
            char[] s1 = sb1.toString().toCharArray();
            Arrays.sort(s1);
            char[] s2 = sb2.toString().toCharArray();
            Arrays.sort(s2);
            StringBuilder s = new StringBuilder();
            s.append(s1).append(s2);
            map.put(s.toString(), map.getOrDefault(s.toString(), 0) + 1);
        }
        return map.size();
    }

    public static String reformat(String s) {
        boolean letter = true;
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length() && j < s.length()) {
            if (letter) {
                while (!Character.isLetter(s.charAt(i))) {
                    i++;
                }
                sb.append(s.charAt(i));
                i++;
            } else {
                while (Character.isLetter(s.charAt(j))) {
                    j++;
                }
                sb.append(s.charAt(j));
                j++;
            }
            letter = !letter;
        }
        return sb.toString();
    }

    public static String formate(String s) {
        int numLe = 0, numNu = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                numNu++;
            } else {
                numLe++;
            }
        }
        if (numLe - numNu > 1 || numNu - numLe > 1) return "";
        if (numLe > numNu) {
            numLe = 0;
            numNu = 1;
        } else {
            numNu = 0;
            numLe = 1;
        }
        char[] ans = new char[s.length()];
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                ans[numNu] = c;
                numNu += 2;
            } else {
                ans[numLe] = c;
                numLe += 2;
            }
        }
        return new String(ans);
    }

    public static String thousandSeparator(int n) {
        String s = new StringBuilder(String.valueOf(n)).reverse().toString();
        int len = s.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len; i++) {
            ans.append(s.charAt(i));
            if (i < len - 1 && (i + 1) % 3 == 0) {
                ans.append(".");
            }
        }
        return ans.reverse().toString();
    }


    public static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                int val = Integer.parseInt(s.substring(i - 2, i));
                sb.append((char) ('a' + (val - 1)));
                i -= 3;
            } else {
                sb.append((char) ('a' + (s.charAt(i) - '0' - 1)));
                i--;
            }
        }
        return sb.reverse().toString();
    }


    public String defangIPaddr(String address) {
        StringBuilder ans = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c != '.') {
                ans.append(c);
            } else {
                ans.append('[').append(c).append(']');
            }
        }
        return ans.toString();
    }

    //a, e, i, o, u
    public static String toGoatLatin(String S) {
        Set<Character> set = new HashSet<Character>() {
            {
                add('a');
                add('e');
                add('i');
                add('o');
                add('u');
                add('A');
                add('E');
                add('I');
                add('O');
                add('U');
            }
        };
        String[] arr = S.split(" ");
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            StringBuilder sb;
            if (set.contains(s.charAt(0))) {
                sb = new StringBuilder();
                sb.append(s).append("ma");
            } else {
                sb = new StringBuilder();
                sb.append(s.substring(1)).append(s.charAt(0)).append("ma");
            }
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            arr[i] = sb.toString();
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            ans.append(arr[i]);
            if (i != arr.length - 1) {
                ans.append(' ');
            }
        }
        return ans.toString();
    }

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1)
            return "";
        char[] arr = palindrome.toCharArray();
        int len = arr.length;
        boolean flag = false;
        for (int i = 0; i < len / 2; ++i) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                flag = true;
                break;
            }
        }
        if (!flag)
            arr[len - 1] = 'b';
        return new String(arr);
    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> st = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '(') {
                stack.push(c);
                st.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    st.pop();
                } else {
                    stack.add(c);
                    st.push(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Set<Integer> indexesToRemove = new HashSet<>();
        while (!st.isEmpty()) indexesToRemove.add(st.pop());
        for (int i = 0; i < arr.length; i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static List<String> ambiguousCoordinates(String S) {
        List<String> ans = new ArrayList();
        for (int i = 2; i < S.length() - 1; ++i)
            for (String left : make(S, 1, i))
                for (String right : make(S, i, S.length() - 1))
                    ans.add("(" + left + ", " + right + ")");
        return ans;
    }

    public static List<String> make(String S, int i, int j) {
        List<String> ans = new ArrayList();
        for (int d = 1; d <= j - i; ++d) {
            String left = S.substring(i, i + d);
            String right = S.substring(i + d, j);
            if ((!left.startsWith("0") || left.equals("0"))
                    && !right.endsWith("0"))
                ans.add(left + (d < j - i ? "." : "") + right);
        }
        return ans;
    }

    public static int numSub1(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int[] sp = new int[len];
        for (int i = 0; i < len; i++) {
            sp[i] = s.charAt(i) == '1' ? (i == 0 ? 1 : sp[i - 1] + 1) : 0;
            dp[i] = Math.floorMod(i == 0 ? sp[i] : sp[i] + dp[i - 1], (int) Math.pow(10, 9) + 7);
        }
        return dp[len - 1];
    }

    public static int numSub(String s) {
        int ans = 0;
        int tmp = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ++tmp;
                ans += tmp;
                if (ans > 1000000006) ans -= 1000000007;
            } else {
                tmp = 0;
            }
        }
        return ans;
    }

    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums.length == 1) {
            sb.append(nums[0]);
        } else if (nums.length == 2) {
            sb.append(nums[0]).append("/").append(nums[1]);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    sb.append(nums[i]).append("/(");
                } else if (i == nums.length - 1) {
                    sb.append(nums[i]).append(")");
                } else {
                    sb.append(nums[i]).append("");
                }
            }
        }
        return sb.toString();
    }

    public static int compress(char[] chars) {
        int ans = 0;
        char pre = chars[0];
        int count = 1;
        int i, a, b, c;
        int index = -1;
        for (i = 1; i <= chars.length; i++) {
            char cur;
            if (i < chars.length) {
                cur = chars[i];
            } else {
                cur = ' ';
            }
            if (pre == cur) {
                count++;
            } else {
                chars[++index] = pre;
                pre = cur;
                ans++;
                if (count > 1) {
                    ans++;
                    chars[++index] = (char) ('0' + count);
                }
                if (count >= 10) {
                    ans++;
                    a = count / 10;
                    b = count % 10;
                    chars[index] = (char) ('0' + a);
                    chars[++index] = (char) ('0' + b);
                } else if (count >= 100) {
                    ans++;
                    a = count / 100;
                    b = (count - a * 100) / 10;
                    c = count - a * 100 - b * 10;
                    chars[index] = (char) ('0' + a);
                    chars[++index] = (char) ('0' + b);
                    chars[++index] = (char) ('0' + c);
                } else if (count >= 1000) {
                    ans++;
                    chars[index] = '1';
                    chars[++index] = '0';
                    chars[++index] = '0';
                    chars[++index] = '0';
                }
                count = 1;
            }
        }
        return ans;
    }


    public static int maxDiff(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int max = num, min = num;
        char[] ma = s.toCharArray();
        char archor = ' ';
        for (int i = 0; i < len; i++) {
            char cur = ma[i];
            if (cur != '9' && archor == ' ') {
                archor = cur;
            }
            if (archor == cur) {
                ma[i] = '9';
            }
        }
        max = Integer.parseInt(new String(ma));
        char[] mi = s.toCharArray();
        char c0 = mi[0];
        if (c0 != '1') {
            for (int i = 0; i < mi.length; i++) {
                if (mi[i] == c0)
                    mi[i] = '1';
            }
        } else {
            for (int i = 1; i < len; i++) {
                char cur = mi[i];
                if (cur != '0' && mi[i] != mi[0]) {
                    for (int j = i; j < len; j++) {
                        if (mi[j] == cur) {
                            mi[j] = '0';
                        }
                    }
                    break;
                }
            }
        }
        min = Integer.parseInt(new String(mi));
        return max - min;
    }


    public static int maxDiff1(int num) {
        char[] ch1 = String.valueOf(num).toCharArray();
        char[] ch2 = ch1.clone();
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != 57) {
                char c = ch1[i];
                for (int j = i; j < ch1.length; j++) {
                    if (ch1[j] == c)
                        ch1[j] = 57;
                }
                break;
            }
        }
        if (ch2[0] != 49) {
            char c = ch2[0];
            for (int i = 0; i < ch2.length; i++) {
                if (ch2[i] == c)
                    ch2[i] = 49;
            }
        } else {
            for (int i = 1; i < ch2.length; i++) {
                if (ch2[i] != 48 && ch2[i] != ch2[0]) {
                    char c = ch2[i];
                    for (int j = i; j < ch2.length; j++) {
                        if (ch2[j] == c)
                            ch2[j] = 48;
                    }
                    break;
                }
            }
        }
        return Integer.parseInt(String.valueOf(ch1)) - Integer.parseInt(String.valueOf(ch2));
    }


    public static int expressiveWords(String S, String[] words) {
        int ans = 0;
        R sR = new R(S);
        String key = sR.key;
        search:
        for (String word : words) {
            R r = new R(word);
            String k = new R(word).key;
            if (!key.equals(k)) continue;
            for (int i = 0; i < sR.count.size(); ++i) {
                int c1 = sR.count.get(i);
                int c2 = r.count.get(i);
                if (c1 < 3 && c1 != c2 || c1 < c2)
                    continue search;
            }
            ans++;
        }
        return ans;
    }

    private static class R {
        public String key;
        public List<Integer> count = new ArrayList<>();

        R(String s) {
            StringBuilder sb = new StringBuilder();
            char[] arr = s.toCharArray();
            int len = arr.length;
            int pre = -1;
            for (int i = 0; i < len; i++) {
                if (i == len - 1 || arr[i] != arr[i + 1]) {
                    sb.append(arr[i]);
                    count.add(i - pre);
                    pre = i;
                }
            }
            key = sb.toString();
        }
    }

    public static int bitwiseComplement(int N) {
        String val = new StringBuilder(Integer.toBinaryString(N)).reverse().toString();
        int ans = 0;
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == '0') {
                ans += Math.pow(2, i);
            }
        }
        return ans;
    }

    public int minMoves(int[] nums) {
        int min = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return sum - min * nums.length;
    }

    public static int trailingZeroes(int n) {
        int ans = 0;
        while (n > 5) {
            n = n / 5;
            ans += n;
        }
        return ans;
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int singleNumberII(int[] A) {
        // write your code here
        return 0;
    }

    public static int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int ans = 0;
        char[] arr = (" " + p).toCharArray();
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            int id = arr[i] - 'a';
            if (check(arr[i - 1], arr[i])) {
                cnt++;
            } else {
                cnt = 1;
            }
            dp[id] = Math.max(dp[id], cnt);
        }
        for (int i = 0; i < 26; i++) {
            ans += dp[i];
        }
        return ans;
    }

    public static boolean check(char a, char b) {
        if (a == 'z' && b == 'a') return true;
        return b - a == 1;
    }

    //输入: [0,1,0,3,12]
    //输出: [1,3,12,0,0]
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public static int missingNumber1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;
        return res;
    }

    public static int countOdds(int low, int high) {
        if (low % 2 != 0) low--;
        if (high % 2 != 0) high++;
        int num = (high - low) / 2;
        return num;
    }


//    public static void main(String[] args) {
////        int[] nums = new int[]{1, 4, 3, 0, 2};
////        System.out.println(countOdds(7, 11));
//        String s = "867758314;867504617;864579114;864280330;864350301;865581497;865801480;865926238;862634726;862815933;863694259;863143650;861024759;861986347;87620682;877639097;877061723;875430263;875072710;872399317;872386515;873383099;870378264;870306515;870903396;871612787;871544738;871346328;879774724;879357798;846037523;847765966;847294832;847113951;844713339;844786472;844935094;845729451;845481099;845301808;84237738;842323064;842807707;843785672;843788037;843150303;840878193;857862034;857917701;854234045;854038457;850698945;850767026;851649622;851394535;858428264;826427505;826061307;824685408;824598259;824118234;825690781;823519055;823949772;820638230;820748600;820482434;821765143;836612686;83651221;836920985;837037625;834523467;834279299;834843900;83555121;83039810;838110560;839778359;806433123;806530631;807790282;807561762;804852861;804988523;805486131;80243278;809791433;809358507;814539138;814110599;814902309;815760125;815137281;812255743;813818607;810349868;811179409;811197044;81958523";
//        String[] ss = s.split(";");
//        System.out.println(ss.length);
//    }

    //1046
    public static int lastStoneWeight(int[] stones) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> (b -a));
        for (int s : stones) {
            p.add(s);
        }
        while (p.size() > 1) {
            int a = p.poll();
            int b = p.poll();
            if (a > b) {
                p.add(a - b);
            }
        }
        return p.isEmpty() ? 0 : p.peek();
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{2,7,4,1,8,1};
//        System.out.println(lastStoneWeight(arr));
        //s = "dcab", pairs = [[0,3],[1,2],[0,2]]
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<List<Integer>>() {
            {
                add(Arrays.asList(0,3));
                add(Arrays.asList(1,2));
                add(Arrays.asList(0,2));
            }
        };
        System.out.println(smallestStringWithSwaps(s,pairs));
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs == null || pairs.size() == 0) return s;
        int n = s.length();
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < pairs.size(); i++) {
            unionFind.union(pairs.get(i).get(0), pairs.get(i).get(1));
        }
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int root = unionFind.find(i);
            if (!map.containsKey(root)) {
                PriorityQueue<Character> tMap = new PriorityQueue<>();
                tMap.offer(s.charAt(i));
                map.put(root, tMap);
            } else {
                map.get(root).offer(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = unionFind.find(i);
            ans.append(map.get(root).poll());
        }
        return ans.toString();
    }

    private static class UnionFind {
        private int[] parent;
        private int[] rank;
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootY]++;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

    }
}
