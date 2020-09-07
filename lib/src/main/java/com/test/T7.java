package com.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

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
        if (null == nums ||nums.length == 1) return nums;
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
            }  else {
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
        ListNode la =head;
        int i = 0;
        while (f != null) {
            f = f.next;
            i++;
            if(i > k) {
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

    public String[] permutation(String s) {

    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
    }

}
