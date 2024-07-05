package com.test;

import java.util.*;

public class T11 {

    class RandomizedSet {
        HashMap<Integer, Integer> map;

        public RandomizedSet() {
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                map.put(val, 1);
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if (map.containsKey(val)) {
                map.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            Object[] arr = (Object[]) (map.keySet().toArray());
            int len = arr.length;
            return (int) arr[new Random().nextInt(len)];
        }
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n)  {
            int sumGas = 0, sumCost = 0, cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) %n;
                sumGas += gas[j];
                sumCost += cost[j];
                if (sumCost > sumGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
        return spare < 0 ? -1 : (minIndex + 1) % len;
    }

    public static int romanToInt(String s) {
        char[] arr = s.toCharArray();
        char pre = ' ';
        int sum = 0;
        for (char c : arr) {
            switch (c) {
                case 'M':
                    sum += 1000;
                    if (pre == 'C') sum -= 200;
                    break;
                case 'D':
                    sum += 500;
                    if (pre == 'C') sum -= 200;
                    break;
                case 'C':
                    sum += 100;
                    if (pre == 'X') sum -= 20;
                    break;
                case 'L':
                    sum += 50;
                    if (pre == 'X') sum -= 20;
                    break;
                case 'X':
                    sum += 10;
                    if (pre == 'I') sum -= 2;
                    break;
                case 'V':
                    sum += 5;
                    if (pre == 'I') sum -= 2;
                    break;
                case 'I':
                    sum += 1;
                    break;
            }
            pre = c;
        }
        return sum;
    }

//    public static void main(String[] args) {
//        romanToInt("DCXXI");
//    }

    public static String intToRoman1(int num) {
        String ns = new StringBuilder().append(num).toString();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < ns.length(); j ++) {
            int b = ns.charAt(j) - '0';
            int carry = (int)Math.pow(10, ns.length() - 1 - j);
            switch (carry) {
                case 1: {
                    if (b == 9) {
                        sb.append("IX");
                    } else if (b == 4) {
                        sb.append("IV");
                    } else {
                        if (b >= 5) {
                            sb.append("V");
                        }
                        for (int i = 0; i < (b >=5? b - 5 : b ) ; i++) {
                            sb.append("I");
                        }
                    }
                }   break;
                case 10:{
                    if (b == 9) {
                        sb.append("XC");
                    } else if (b == 4) {
                        sb.append("XL");
                    } else {
                        if (b >= 5) {
                            sb.append("L");
                        }
                        for (int i = 0; i < (b >=5? b - 5 : b ) ; i++) {
                            sb.append("X");
                        }
                    }
                } break;
                case 100: {
                    if (b == 9) {
                        sb.append("CM");
                    } else if (b == 4) {
                        sb.append("CD");
                    } else {
                        if (b >= 5) {
                            sb.append("D");
                        }
                        for (int i = 0; i < (b >=5? b - 5 : b ) ; i++) {
                            sb.append("C");
                        }
                    }
                }
                    break;
                case 1000: {
                    for (int i = 0; i < b; i ++ ) {
                        sb.append("M");
                    }
                }
                    break;
            }
        }

        return sb.toString();
    }

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num > value) {
                sb.append(symbol);
                num -= value;
            }
            if (num == 0) break;
        }
        return sb.toString();
    }

    public static int lengthOfLastWord(String s) {
        int n = s.length();
        int cnt = 0;
        for (int i = n - 1; i >=0; i--) {
            if (s.charAt(i) != ' ') {
                cnt++;
            } else if (cnt > 0) {
                break;
            }
        }
        return cnt;
    }

    public static boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 != 0) {
            n = n / 3;
        }
        return n == 1;
    }

//    public static void main(String[] args) {
////        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
//        System.out.println(isPowerOfThree(1));
//    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static int maxDepth(TreeNode root) {
        if (null == root) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)return true;
        if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val)) return false;
        if (p.left == null && p.right == null && q.left == null && q.right == null && p.val == q.val) return true;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
//    public static void main(String[] args) {
//        TreeNode p  = new TreeNode(5);
//        TreeNode p1 = new TreeNode(5);
//        p.right = p1;
//        TreeNode p12 = new TreeNode(-3);
//        p1.right = p12;
//        TreeNode q = new TreeNode(5);
//        TreeNode q1 = new TreeNode(-3);
//        q.left = q1;
//        TreeNode q12 = new TreeNode(9);
//        q1.left = q12;
//        System.out.println(isSameTree(p, q));
//    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        invert(root);
        return root;
    }

    private static void invert(TreeNode root) {
        if (null == root) return;
        if (root.left == null && root.right == null) return;
        TreeNode left = root.left, right = root.right;
        root.left = right;
        root.right = left;
        invert(root.left);
        invert(root.right);
    }

    public static TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree1(root.left);
        TreeNode right = invertTree1(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static boolean isSymmetric(TreeNode root) {
        if (null == root) return true;
        return isSame(root.left, root.right);
    }

    private static boolean isSame(TreeNode left ,TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSame(left.right, right.left) &&isSame(left.left, right.right);
    }

//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode left = new TreeNode(2);
//        root.left = left;
//        invertTree(root);
//    }

    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

//    public static void main(String[] args) {
//    //输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//        //输出: [3,9,20,null,null,15,7]
//        int[] preorder = new int[]{3,9,20,15,7}, inorder = new int[]{9,3,15,20,7};
//        TreeNode node = new T11().buildTree(preorder, inorder);
//    }

    public int calculate(String s) {
        if (null == s || s.length() == 0) return 0;
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        int n = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                n = n * 10 + c - '0';
            }
            if (!Character.isDigit(c) || i == s.length() - 1) {
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
                    default:
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

    class Solution {
        public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
            int n = edges.length + 1;
            List<int[]>[] graph = new ArrayList[n];
            Arrays.setAll(graph, i -> new ArrayList<>());

            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                int w = e[2];
                graph[u].add(new int[]{v, w});
                graph[v].add(new int[]{u, w});
            }

            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                int pre = 0;
                for (int[] e : graph[i]) {
                    int cnt = dfs(e[0], i, e[1] % signalSpeed, signalSpeed, graph);
                    res[i] += pre * cnt;
                    pre += cnt;
                }
            }
            return res;
        }

        private int dfs(int p, int root, int curr, int signalSpeed, List<int[]>[] graph) {
            int res = 0;
            if (curr == 0) {
                res++;
            }
            for (int[] e : graph[p]) {
                int v = e[0];
                int cost = e[1];
                if (v != root) {
                    res += dfs(v, p, (curr + cost) % signalSpeed, signalSpeed, graph);
                }
            }
            return res;
        }
    }


    public static int findTarget(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        if (nums.length == 1) return 0;
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        int len = nums.length;
        int left = 0, right = len - 1;
        int mid = 0;
        while (left < right) {
            mid = (right + left) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) break;
            if (nums[mid - 1] > nums[mid]) {
                right = mid;
            } else if (nums[mid + 1] > nums[mid]) {
                left = mid;
            }
        }
        return mid;
    }

//    public static void main(String[] args) {
////        System.out.println(findTarget(new int[] {2,4,1,2,9,8,4}));
////        System.out.println(findTarget(new int[] {3,6}));
//        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
//        reverseBetween(node, 2, 4);
//        System.out.println(1);
//    }


     public static class ListNode {
        int val;
       ListNode next = null;
       public ListNode(int val) {
         this.val = val;
       }
     }


    public static ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode pre = new ListNode(0);
        ListNode next = new ListNode(0);
        pre.next = next;
        ListNode tmp = null;
        ListNode first = null;
        int index = 1;
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            if (index < m) {
                ListNode t = new ListNode(head.val);
                next.next = t;
                next = t;
            } else if (index > n) {
                while (!stack.isEmpty()) {
                    ListNode t = new ListNode(stack.pop());
                    next.next = t;
                    next = t;
                }
                ListNode t = new ListNode(head.val);
                next.next = t;
                next = t;
            } else {
                stack.push(head.val);
            }
            head = head.next;
            index++;
        }
        while (!stack.isEmpty()) {
            ListNode t = new ListNode(stack.pop());
            next.next = t;
            next = t;
        }
        return pre.next.next;
    }

    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        // write code here
        ListNode pre = new ListNode(0);
        ListNode next = new ListNode(0);
        pre.next = next;
        while (pHead1 != null || pHead2 != null) {
            int p1;
            int p2;
            ListNode node = null;
            if (pHead1 != null && pHead2 != null) {
                p1 = pHead1.val;
                p2 = pHead2.val;
                if (p1 <= p2) {
                    node = new ListNode(p1);
                    pHead1 = pHead1.next;
                } else if (p2 < p1) {
                    node = new ListNode(p2);
                    pHead2 = pHead2.next;
                }
                next.next = node;
                next = node;
            } else if (pHead1 != null) {
                node = new ListNode(pHead1.val);
                next.next = node;
                next = node;
                pHead1 = pHead1.next;
            } else if (pHead2 != null) {
                node = new ListNode(pHead2.val);
                next.next = node;
                next = node;
                pHead2 = pHead2.next;
            }
        }
        return pre.next.next;
    }

    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        // write code here
        ArrayList<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            ListNode listNode = lists.get(i);
            while (listNode != null) {
                listInt.add(listNode.val);
                listNode = listNode.next;
            }
        }
        Integer[] arr = new Integer[listInt.size()];
        listInt.toArray(arr);
        Arrays.sort(arr);
        ListNode pre = new ListNode(0);
        ListNode next = new ListNode(0);
        pre.next = next;
        ListNode tmp = null;
        for (int i = 0; i < arr.length; i++) {
            tmp = new ListNode(arr[i]);
            next.next = tmp;
            next = tmp;
        }
        return pre.next.next;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return pHead;
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) return null;
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode tmp = pHead;
        int len = 0;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }
        int index = 0;
        while (pHead != null) {
            if (index + k == len) break;
            index++;
            pHead = pHead.next;
        }
        return pHead;
    }

//    public static void main(String[] args) {
////        System.out.println(findTarget(new int[] {2,4,1,2,9,8,4}));
////        System.out.println(findTarget(new int[] {3,6}));
//        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
//        FindKthToTail(node, 2);
//        System.out.println(1);
//    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> s1 = new HashSet<>();
        while (pHead1 != null) {
            s1.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (s1.contains(pHead2)) return pHead2;
            pHead2 = pHead2.next;
        }
        return null;
    }

//    public static void main(String[] args) {
////        System.out.println(findTarget(new int[] {2,4,1,2,9,8,4}));
////        System.out.println(findTarget(new int[] {3,6}));
//        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
//        FindKthToTail(node, 2);
//        System.out.println(1);
//    }

    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        while (head1 != null) {
            l1.add(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            l2.add(head2.val);
            head2 = head2.next;
        }
        int len1 = l1.size(), len2 = l2.size();
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        int i = len1 - 1, j = len2 - 1;
        while (i >= 0 || j >= 0 ) {
            int a = i >= 0 ? l1.get(i) : 0;
            int b = j >= 0 ? l2.get(j) : 0;
            int c = a + b + carry;
            res.add(c % 10);
            carry = c /10;
            i--;
            j--;
        }
        if (carry > 0) res.add(carry);
        ListNode ans = new ListNode(0);
        ListNode next = ans;
        ListNode tmp;
        for (int k = res.size()-1; k >=0; k--) {
            tmp = new ListNode(res.get(k));
            next.next = tmp;
            next = tmp;
        }
        return ans.next;
    }

    public ListNode sortInList (ListNode head) {
        // write code here
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        ListNode res = new ListNode(0);
        ListNode next = res;
        ListNode tmp = null;
        for (Integer i : list) {
            tmp = new ListNode(i);
            next.next = tmp;
            next = tmp;
        }
        return res.next;
    }

//    public static void main(String[] args) {
////        System.out.println(findTarget(new int[] {2,4,1,2,9,8,4}));
////        System.out.println(findTarget(new int[] {3,6}));
//        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
//        FindKthToTail(node, 2);
//        System.out.println(1);
//    }

    public static boolean isPail (ListNode head) {
        // write code here
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int len = list.size();
        if (len <= 1) return true;
        int mid = (len -1) / 2;
        if (len == 2) return list.get(0) == list.get(1);
        int left, right;
        left = len % 2 == 0 ? mid : mid - 1;
        right = mid + 1;
        while (left >= 0 && right <= list.size() -1) {
            if (list.get(left).intValue() != list.get(right).intValue()) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    public static boolean isPail1(ListNode head) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        ArrayList<Integer> tmp = (ArrayList<Integer>)list.clone();
        Collections.reverse(tmp);
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            int y = tmp.get(i);
            if (x != y) return false;
        }

        return true;
    }

//    public static void main(String[] args) {
////        System.out.println(findTarget(new int[] {2,4,1,2,9,8,4}));
////        System.out.println(findTarget(new int[] {3,6}));
//        ListNode node = new ListNode(-401261);
//        node.next = new ListNode(-449050);
//        node.next.next = new ListNode(-456674);
//        node.next.next.next = new ListNode(-456674);
//        node.next.next.next.next = new ListNode(-449050);
//        node.next.next.next.next.next = new ListNode(-401261);
////        node.next.next.next.next.next.next = new ListNode(3);
////        node.next.next.next.next.next.next.next = new ListNode(2);
////        node.next.next.next.next.next.next.next.next = new ListNode(1);
////        node.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        System.out.println(isPail(node));
//        System.out.println(1);
//    }

    public static ListNode oddEvenList (ListNode head) {
        // write code here
        ListNode a = new ListNode(0);
        ListNode atmp = a;
        ListNode b = new ListNode(0);
        ListNode btmp = b;
        int index = 1;
        ListNode tmp;
        while (head != null) {
            tmp = new ListNode(head.val);
            if (index % 2 != 0) {
                atmp.next = tmp;
                atmp = tmp;
            } else {
                btmp.next = tmp;
                btmp = tmp;
            }
            index++;
            head = head.next;
        }
        atmp.next = b.next;
        return a.next;
    }

//    public static void main(String[] args) {
////        System.out.println(findTarget(new int[] {2,4,1,2,9,8,4}));
////        System.out.println(findTarget(new int[] {3,6}));
//        ListNode node = new ListNode(1);
//        node.next = new ListNode(1);
////        node.next.next = new ListNode(2);
////        node.next.next.next = new ListNode(3);
////        node.next.next.next.next = new ListNode(3);
////        node.next.next.next.next.next = new ListNode(3);
////        node.next.next.next.next.next.next = new ListNode(3);
////        node.next.next.next.next.next.next.next = new ListNode(2);
////        node.next.next.next.next.next.next.next.next = new ListNode(1);
////        node.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        System.out.println(deleteDuplicates2(node));
//        System.out.println(1);
//    }

    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        Set<Integer> set = new HashSet<>();
        ListNode res = new ListNode(0);
        ListNode cur = res;
        ListNode tmp = null;
        while (head != null) {
            if (!set.contains(head.val)) {
                tmp = new ListNode(head.val);
                cur.next = tmp;
                cur = tmp;
                set.add(head.val);
            }
            head = head.next;
        }
        return res.next;
    }

    public static ListNode deleteDuplicates2 (ListNode head) {
        // write code here
        if (null == head) return head;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        ListNode pre = cur;
        ListNode tmp = null;
        int preVal = head.val;
        cur.next = new ListNode(preVal);
        cur = cur.next;
        head = head.next;
        while (head != null) {
            int curVal = head.val;
            if (curVal == preVal) {
                pre.next = null;
                cur = pre;
            } else {
                preVal = curVal;
                pre.next = cur;
                pre = cur;
                tmp = new ListNode(curVal);
                cur.next = tmp;
                cur = tmp;
            }
            head = head.next;
        }
        return res.next;
    }

    public static ListNode deleteDuplicates21 (ListNode head) {
        // write code here
        if (null == head) return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int tmp = cur.next.val;
                while (cur.next != null && cur.next.val == tmp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return res.next;
    }

    /**
     *
     * @return
     */
//    public int InversePairs (int[] nums) {
//        // write code here
//    }
//    import java.util.*;
//    class BIT {
//        private int[] tree;
//        private int n;
//        //初始化树状数组的大小
//        public BIT(int m) {
//            this.n = m;
//            this.tree = new int[m + 1];
//        }
//        //使数组呈现2、4、8、16这种树状
//        public int lowbit(int x) {
//            return x & (-x);
//        }
//        //查询序列1到x的前缀和
//        public int query(int x) {
//            int res = 0;
//            while(x != 0){
//                res += tree[x];
//                x -= lowbit(x);
//            }
//            return res;
//        }
//        //序列x位置的数加1
//        public void update(int x) {
//            while(x <= n){
//                tree[x]++;
//                x += lowbit(x);
//            }
//        }
//    }
//
//    public class Solution {
//        public int mod = 1000000007;
//        public int InversePairs(int [] array) {
//            int n = array.length;
//            int[] temp = new int[n];
//            System.arraycopy(array, 0, temp, 0, n);
//            //排序得到一份有序的数组
//            Arrays.sort(temp);
//            //二分法重新映射，将数字变成其在有序数组中的位置
//            for (int i = 0; i < n; ++i)
//                //二分法查找在其在有序数组中的位置
//                array[i] = Arrays.binarySearch(temp, array[i]) + 1;
//            //建立大小为n的树状数组
//            BIT bit = new BIT(n);
//            int res = 0;
//            //统计逆序对
//            for(int i = 0; i < n; i++){
//                //前缀和做差
//                res = (res + bit.query(n) - bit.query(array[i])) % mod;
//                bit.update(array[i]);
//            }
//            return res;
//        }
//    }

    public int compare (String version1, String version2) {
        // write code here
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j = 0;
        int l1 = v1.length, l2 = v2.length;
        while (i <= l1 -1 || j <= l2 - 1) {
            String s1 = i <= l1 -1 ? v1[i] : "0";
            String s2 = j <= l2 -1 ? v2[j] : "0";
            int a1 = 0, a2 = 0;
            a1 = Integer.parseInt(s1);
            a2 = Integer.parseInt(s2);
            if (a1 == a2) {
                i++;
                j++;
                continue;
            }
            if (a1 > a2) return 1;
            else return -1;
        }
        return 0;
    }


    public static int[] preorderTraversal (TreeNode root) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        preorder(root, list);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i).intValue();
        }
        return ans;
    }

    public static void preorder (TreeNode root, List<Integer> list) {
        // write code here
        if (null != root) {
            list.add(root.val);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }

    public int[] inorderTraversal(TreeNode root) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i).intValue();
        }
        return ans;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        // write code here
        if (null != root) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }

    public int[] postorderTraversal (TreeNode root) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        postorder(root, list);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i).intValue();
        }
        return ans;
    }

    public void postorder(TreeNode root, List<Integer> list) {
        // write code here
        if (null != root) {
            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root.val);
        }
    }
//    public static void main(String[] args) {
//        TreeNode a = new TreeNode(3);
//        TreeNode b = new TreeNode(2, a, null);
//        TreeNode root = new TreeNode(1, null, b);
//        preorderTraversal(root);
//        System.out.println(1);
//    }

    public int maxDepth1 (TreeNode root) {
        // write code here
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;

    }


    TreeNode head;
    TreeNode pre;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Convert(pRootOfTree.left);
        if (null == pre) {
            pre = pRootOfTree;
            head = pRootOfTree;
        } else {
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return head;
    }

    public void Convert1(TreeNode pRootOfTree, TreeNode cur) {
        if (null != pRootOfTree) {
            Convert1(pRootOfTree.left, cur);
            TreeNode tmp = new TreeNode(pRootOfTree.val);
            if (null != cur.left) {
                tmp.left = cur;
            }
            cur.right = tmp;
            cur = tmp;
            Convert1(pRootOfTree.right, cur);
        }
    }

//    public static void main(String[] args) {
//        TreeNode a1 = new TreeNode(4);
//        TreeNode a2 = new TreeNode(8);
//        TreeNode a = new TreeNode(6, a1, a2);
//        TreeNode b1 = new TreeNode(12);
//        TreeNode b2 = new TreeNode(16);
//        TreeNode b = new TreeNode(14, b1, b2);
//        TreeNode root = new TreeNode(10, a, b);
//        T11 t = new T11();
//        t.Convert(root);
//        System.out.println(1);
//    }

    TreeNode ans;
    TreeNode cur;
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode ans = new TreeNode(t1.val + t2.val);
        ans.left = mergeTrees(t1.left, t2.left);
        ans.right = mergeTrees(t1.right, t2.right);
        return ans;
    }

    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if (pRoot != null) {
            TreeNode tmp = pRoot.left;
            pRoot.left = pRoot.right;
            pRoot.right = tmp;
            Mirror(pRoot.left);
            Mirror(pRoot.right);
        }
        return pRoot;
    }

    int preV = Integer.MIN_VALUE;
    public boolean isValidBST (TreeNode root) {
        // write code here
        if (null == root) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val < preV) return false;
        preV = root.val;
        return isValidBST(root.right);
    }


    public void swap(int[] arr , int i , int j) {
        int t = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = t ;
    }
    public int minNumberDisappeared (int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i+ 1;
            }
        }
        return len + 1;
    }

//    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3, -1};
//        T11 t = new T11();
//        System.out.println(t.minNumberDisappeared(nums));
//    }

    public boolean isCompleteTree (TreeNode root) {
        //空树一定是完全二叉树
        if(root == null)
            return true;
        //辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        //定义一个首次出现的标记位
        boolean notComplete = false;
        while(!queue.isEmpty()){
            cur = queue.poll();
            //标记第一次遇到空节点
            if(cur == null){
                notComplete = true;
                continue;
            }
            //后续访问已经遇到空节点了，说明经过了叶子
            if(notComplete)
                return false;
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return true;
    }

//    Stack<Integer> stack1 = new Stack<Integer>();
//    Stack<Integer> stack2 = new Stack<Integer>();
//    public void push(int node) {
//        stack1.push(node);
//    }
//
//    public int pop() {
//        while (!stack1.isEmpty()) {
//            stack2.push(stack1.pop());
//        }
//        if(!stack2.isEmpty()) {
//            int ret = stack2.pop();
//            while(!stack2.isEmpty()) {
//                stack1.push(stack2.pop());
//            }
//            return ret;
//        }
//        return -1;
//    }

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minstack = new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
        if (minstack.isEmpty() || minstack.peek() > node) {
            minstack.push(node);
        } else {
            minstack.push(minstack.peek());
        }

    }

    public void pop() {
        stack.pop();
        minstack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minstack.peek();
    }

    public boolean isValid (String s) {
        // write code here
        Stack<Character> st = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if (st.isEmpty()) {
                st.push(c);
            } else {
                char top = st.peek();
                switch (top) {
                    case '{':
                        if (c == '}') {
                            st.pop();
                        } else {
                            st.push(c);
                        }
                        break;
                    case '(':
                        if (c == ')') {
                            st.pop();
                        } else {
                            st.push(c);
                        }
                        break;
                    case '[':
                        if (c == ']') {
                            st.pop();
                        } else {
                            st.push(c);
                        }
                        break;
                    default:
                        st.push(c);
                        break;
                }
            }
        }
        return st.isEmpty();
    }

//    public static void main(String[] args) {
//        T11 t = new T11();
//        System.out.println(t.isValid("[(}]"));
//    }

    public ArrayList<Integer> maxInWindows (int[] num, int size) {
        // write code here
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (size == 0) return ans;

        for (int i = 0; i < num.length; i ++ ) {

            while (!deque.isEmpty() && deque.peek() < i - size + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= size - 1) {
                ans.add(num[deque.peek()]);
            }
        }

        return ans;
    }

    /**
     * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
     */
//    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
//        // write code here
//        int len = input.length;
//        ArrayList<Integer> ans = new ArrayList<>();
//        if (k >= len) {
//            for (int i = 0; i < len; i++) {
//                ans.add(input[i]);
//            }
//            return ans;
//        }
//
//    }

//    public String trans (String s, int n) {
//        // write code here
//        String sb
//    }

    public boolean judge (String str) {
        // write code here
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString().equals(str);
    }
    public static boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'A' && c <= 'Z') || ( c >= 'a' && c <= 'z')) {
                sb.append(Character.toLowerCase(c));
            }
        }
        System.out.println(sb.toString());
        System.out.println(sb.reverse().toString());
        return sb.toString().equals(sb.reverse().toString());
    }

//    public static void main(String[] args) {
//        System.out.println(isPalindrome("0P"));
//    }

    public ListNode Merge11(ListNode pHead1, ListNode pHead2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        ListNode tmp = null;
        while(pHead1 != null || pHead2 != null) {
            if (pHead1 != null && pHead2 != null) {
                if (pHead1.val <= pHead2.val) {
                    tmp = new ListNode(pHead1.val);
                    pHead1 = pHead1.next;
                } else {
                    tmp = new ListNode(pHead2.val);
                    pHead2 = pHead2.next;
                }
                cur.next = tmp;
                cur = tmp;
            } else if (pHead1 != null) {
                cur.next = pHead1;
            } else {
                cur.next = pHead2;
            }
        }
        return res.next;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i< magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        boolean ans = true;
        for (int i = 0; i < ransomNote.length(); i++) {
            int v = map.getOrDefault(ransomNote.charAt(i), 0);
            if(v <=0) return false;
            map.put(ransomNote.charAt(i), v-1);
        }
        return ans;
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> maps = new HashMap<>();
        HashMap<Character, Character> mapt = new HashMap<>();
        for (int i = 0; i< s.length(); i++) {
            Character a = s.charAt(i);
            Character b = t.charAt(i);
            if((maps.containsKey(a) && maps.get(a) != b) || (mapt.containsKey(b) && mapt.get(b) != a)) {
                return false;
            }
            maps.put(a, b);
            mapt.put(b, a);
        }
        return true;
    }

    public static boolean wordPattern(String pattern, String s) {
        int lp = pattern.length();
        String[] ss = s.split(" ");
        int ls = ss.length;
        if (lp != ls) return false;
        Map<Character, String> mp = new HashMap<>();
        Map<String, Character> ms = new HashMap<>();
        for (int i = 0; i < lp; i++) {
            char a = pattern.charAt(i);
            String b = ss[i];
            if ((mp.containsKey(a) && !mp.get(a).equals(b)) || (ms.containsKey(b) && !ms.get(b).equals(a))){
                return false;
            }
            mp.put(a, b);
            ms.put(b, a);
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                ans[0] = map.get(nums[i]);
                ans[1] = i;
                break;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return ans;
    }

    public int[] solve (int n, int m, int[] a) {
        // write code here
        m = m % n;
        reverse(a, 0, n - 1 );
        reverse(a, 0, m - 1);
        reverse(a, m, n);
        return a;
    }

    public void reverse(int[] a, int start, int end) {
        while (start < end) {
            swap1(a, start++, end--);
        }
    }

    public void swap1(int[] mums, int a, int b) {
        int tmp = mums[a];
        mums[a] = mums[b];
        mums[b] = tmp;
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String ans = strs[0];
        int len = ans.length();
        int ret = 0;
        for(int i = 0; i < ans.length(); i++) {
            char a = ans.charAt(i);
            for (String s: strs) {
                if (i == s.length() || s.charAt(i) != a) {
                    return ans.substring(0, i);
                }
            }
        }
        return ans;
    }

    public String reverseWords(String s) {
        if (null == s || "".equals(s)) return s;
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length -1; i>=0; i--) {
            if (!"".equals(arr[i]) && " ".equals(arr[i])) {
                sb.append(arr[i]);
                sb.append(" ");
            }
        }
        String ans = sb.toString();
        return ans.substring(0, ans.length() -1);
    }

    public static String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> list = new ArrayList<>(3);
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if (i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : list) {
            ans.append(sb.toString());
        }
        return ans.toString();
    }

    public int strStr(String haystack, String needle) {
        char[] hh = haystack.toCharArray();
        int n = hh.length;
        char[] nn = needle.toCharArray();
        int m = nn.length;
        for (int i = 0; i <= n - m; i++) {
            int a = i, b = 0;
            while (b < m && hh[a] == nn[b]) {
                a++;
                b++;
            }
            if (b == m) return i;
        }

        return -1;
    }

    public static boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j) ) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num :nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) {
            if (!set.contains(num -1)) {
                int current = num;
                int len = 1;
                while (set.contains(num + 1)) {
                    current +=1;
                    len++;
                }
                ans = Math.max(len, ans);
            }
        }
        return ans;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < len) {
            sum+= nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int len = arr.length;
        int right = -1, ans = 0;
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                set.remove(arr[i -1]);
            }

            while (right + 1 < len && !set.contains(arr[right + 1])) {
                set.add(arr[right+ 1]);
                right++;
            }
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }

    public static List<Integer> findSubstring1(String s, String[] words) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int len = 0;
        int m = words[0].length();
        for (String ss : words) {
            len += ss.length();
        }
        int n = s.length();
        if (n < len) return ans;
        int start = 0, end = len - 1;
        while (start < n && end < n) {
            String cur = s.substring(start, end + 1);
            HashMap<String, Integer> map = new HashMap<>();
            int index = start;
            while ( index < end) {
                String t = cur.substring(index, index + m);
                map.put(t, map.getOrDefault(t, 0));
            }
            boolean ret = true;
            for (String tmp: words) {
                if (!map.containsKey(tmp)) {
                    ret = false;
                    break;
                } else {
                    int cnt = map.get(tmp);
                    if (cnt == 1) {
                        map.remove(tmp);
                    } else {
                        cnt--;
                        map.put(tmp, cnt);
                    }
                }
            }
            if (ret) {
                ans.add(start);
            }
            start++;
            end++;
        }
        return ans;
    }

    public static List<Integer> findSubstring(String s, String[] words){
        List<Integer> res = new ArrayList<Integer>();
        int m = words.length, n = words[0].length(), ls = s.length();
        for (int i = 0; i < n; i++) {
           if (i + m * n > ls) break;
           HashMap<String, Integer> map = new HashMap<>();
           for (int j = 0; j < m; j++) {
               String t = s.substring(i + j * n, i + (j+1)*n);
               map.put(t, map.getOrDefault(t, 0) + 1);
           }
           for (String word :words) {
               map.put(word, map.getOrDefault(word, 0) -1);
               if (map.get(word) == 0) map.remove(word);
           }
           for (int start = i; start < ls - m*n + 1; start+=n) {
               if (start != i) {
                   String r = s.substring(start + (m -1)* n, start + m *n);
                   map.put(r, map.getOrDefault(r, 0) + 1);
                   if (map.get(r) == 0) map.remove(r);
                   r = s.substring(start -n, start);
                   map.put(r, map.getOrDefault(r, 0) - 1);
                   if (map.get(r) == 0) map.remove(r);
               }
               if (map.isEmpty()) res.add(start);

           }
        }
        return res;

    }
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int start = -1;
        int pre = -1;
        for (int i = 0; i < nums.length;i++) {
            if (start == -1) {
                start = i;
            } else {
                if (Math.abs(nums[i] - pre) > 1) {
                    if (start == i - 1) {
                        ans.add(String.valueOf(nums[start]));
                    } else {
                        ans.add(String.valueOf(nums[start] + "->" + nums[i - 1]));
                    }
                    start = i;
                }
            }
            pre = nums[i];
        }
        if (start != -1) {
            if (start == nums.length - 1) {
                ans.add(String.valueOf(nums[start]));
            } else {
                ans.add(String.valueOf(nums[start] + "->" + nums[nums.length - 1]));
            }
        }
        return ans;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merge = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merge.size() == 0 || merge.get(merge.size() -1)[1] < L) {
                merge.add(new int[]{L, R});
            } else {
                int[] item = new int[]{merge.get(merge.size() -1)[0], R};
                merge.get(merge.size() -1)[1] = Math.max(merge.get(merge.size() -1)[1], R);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[0][2];
        List<int[]> merge = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!placed) {
                    merge.add(new int[]{left, right});
                    placed = true;
                }
                merge.add(new int[]{left, right});
            } else if (interval[1] < left) {
                merge.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right= Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            merge.add(new int[]{left, right});
        }
        return merge.toArray(new int[merge.size()][]);
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]){
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        ans.add(points[0]);
        //[[-2147483646,-2147483645],[2147483646,2147483647]]
        for (int i = 1; i < points.length; i++) {
            int l = points[i][0], r = points[i][1];
            int L = ans.get(ans.size() -1)[0], R = ans.get(ans.size() -1)[1];
            if (l < R) {
                ans.get(ans.size() -1)[0] = l;
                ans.get(ans.size() -1)[1] = Math.min(R, r);
            } else if (l == R) {
                ans.get(ans.size() -1)[0] = l;
                ans.get(ans.size() -1)[1] = R;
            } else {
                ans.add(new int[]{l, r});
            }
        }
        return ans.size();
    }


//    public boolean isValid(String s) {
//        if (s.length() == 1) return false;
//        Stack<Character> st = new Stack<>();
//        for (char c : s.toCharArray()) {
//            if ( c == '(' || c =='{' || c == '[') {
//                st.push(c);
//            } else if (c == ')') {
//                if (!st.isEmpty() && st.peek() == '(') {
//                    st.pop();
//                } else {
//                    return false;
//                }
//            } else if (c == '}') {
//                if (!st.isEmpty() && st.peek() == '{') {
//                    st.pop();
//                } else {
//                    return false;
//                }
//            } else if (c == ']') {
//                if (!st.isEmpty() && st.peek() == '[') {
//                    st.pop();
//                } else {
//                    return false;
//                }
//            } else {
//                return false;
//            }
//        }
//        return st.isEmpty();
//    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        ListNode tmp;
        while(list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                int a1 = list1.val;
                int a2 = list2.val;
                if (a1 <= a2) {
                    tmp = new ListNode(a1);
                    cur.next = tmp;
                    cur = tmp;
                    list1 = list1.next;
                } else {
                    tmp = new ListNode(a2);
                    cur.next = tmp;
                    cur = tmp;
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                tmp = new ListNode(list1.val);
                cur.next = tmp;
                cur = tmp;
                list1 = list1.next;
            } else {
                tmp = new ListNode(list2.val);
                cur.next = tmp;
                cur = tmp;
                list2 = list2.next;
            }
        }
        return ans.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }
        return map.get(head);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i<n; i++) {
            fast = fast.next;
        }
        while(fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return ans.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        int pre = head.val;
        head = head.next;
        int count = 1;
        while(head != null) {
            if (pre == head.val) {
                count++;
            } else {
                if (count == 1) {
                    ListNode tmp = new ListNode(pre);
                    cur.next = tmp;
                    cur = tmp;
                }
                pre = head.val;
                count = 1;
            }
            head = head.next;
        }
        if (count == 1) {
            cur.next = new ListNode(pre);
        }
        return ans.next;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        int add = len - k%len;
        if (add == len) return head;
        tmp.next = head;
        while (add-- > 0) {
            tmp = tmp.next;
        }
        ListNode ans = tmp.next;
        tmp.next = null;
        return ans;
    }


//    public static void main(String[] args) {
////        System.out.println(wordPattern( "abba", "dog cat cat dog"));
////        System.out.println(convert( "leetcode", 4));
////        System.out.println(minSubArrayLen( 11, new int[] {1,2,3,4,5}));
////        System.out.println(findSubstring( "barfoothefoobarman", new String[]{"foo","bar"}));
////        insert(new int[][]{{1,3},{6,9}}, new int[]{2, 5});
////        findMinArrowShots(new int[][] {{-2147483646,-2147483645}, {2147483646,2147483647}});
//
//        //[[7,null],[13,0],[11,4],[10,2],[1,0]]
////        Node n1 = new Node(7);
////        Node n2 = new Node(13);
////        Node n3 = new Node(11);
////        Node n4 = new Node(10);
////        Node n5 = new Node(1);
////        System.out.println(1^1);
//        System.out.println(NumberOf1Between1AndN_Solution(13));
//
//    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        int ans = 0;
        for(int i = 0; i <=n; i++) {
            int carry = 0;
            int j = i;
            while (j > 0) {
                carry = j %10;
                j = j /10;
                if ((carry^1)==0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n== 0) return;
        int[] ans = new int[m+n];
        int i = 0,j=0, k= 0;
        while(i <m || j <n) {
            if (i>=m) {
                ans[k] = nums2[j];
                j++;
            } else if (j >=n) {
                ans[k] = nums1[i];
                i++;
            } else {
                int a = nums1[i];
                int b = nums2[j];
                if ( a <= b) {
                    ans[k] = a;
                    i++;
                } else {
                    ans[k] = b;
                    j++;
                }
            }
            k++;
        }
        for(int l = 0; l < m+n;l++) {
            nums1[l] = ans[l];
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x= 0, y = n -1;
        while (x < m && y >= 0) {
            if (target == matrix[x][y]) {
                return true;
            }
            if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }

    public int superEggDrop(int k, int n) {
        int ans = 0;
        while (n > 0) {
            n /=2;
            ans++;
        }
        return 0;
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] subboxs = new int[3][3][9];
        for (int i = 0; i < 9;i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' -1;
                    rows[i][index]++;
                    cols[j][index]++;
                    subboxs[i/3][j/3][index]++;
                    if (rows[i][index] > 1|| cols[j][index]> 1|| subboxs[i/3][j/3][index]>1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<Integer>();
        int l = 0, r = matrix[0].length - 1, t = 0 , b = matrix.length-1, x = 0;
        Integer[] ans = new Integer[(r+ 1) *(b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) {
                //left to right
                ans[x++] = matrix[t][i];
            }
            if (++t > b) break;
            for (int i = t; i <= b; i++) {
                //top to bottom
                ans[x++] = matrix[i][r];
            }
            if (l> --r) break;
            for (int i = r; i >= l; i--) {
                //from right to left
                ans[x++] = matrix[b][i];
            }
            if (t> --b) break;
            for (int i = b; i>= t; i--) {
                //bottom to top
                ans[x++] = matrix[i][l];
            }
            if (++l < r) break;
        }

        return Arrays.asList(ans);
    }

    public int reverseBits(int n) {
        char[] arr = new StringBuilder(Integer.toBinaryString(n)).reverse().toString().toCharArray();
        int ans = 1;
        for (char c :arr) {
            ans = ans *2 + (c - '0');
        }
        return ans;
    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for (Integer key :map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }

    public static int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 1; i <= n;i++) {
            int tmp = i;
            while(tmp >0 && tmp%5 == 0) {
                tmp /=5;
                ans++;
            }
        }
        return ans;
    }

    public static int mySqrt(int x) {
        if (x == 1) return 1;
        int left = 1, right = x/2;
        while (left < right) {
            int mid = (left + right) /2;
            if (mid * mid > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static int distance(int[][] nums) {
        int ans = 0;
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int ret = (o1[0]*o1[0] + o1[1]*o1[1]) - (o2[0]*o2[0] + o2[1]*o2[1]);
                if (ret == 0) {
                    int r0 = o1[0] - o2[0];
                    if (r0 != 0) return r0;
                    int r1 = o2[1] - o1[1];
                    return r1;
                }
                return ret;
            }
        });
        for (int i = 0 ; i < nums.length; i++) {
            int[] tmp = nums[i];
            if (i == 0) {
                ans += Math.sqrt(tmp[0]* tmp[0] + tmp[1]*tmp[1]);
            } else {
                int[] t1 = nums[i-1];
                ans += Math.sqrt((t1[0] - tmp[0])*(t1[0] - tmp[0]) + (t1[1] - tmp[1])*(t1[1] - tmp[1]));
            }
            if (i == nums.length -1 ) {
                ans += Math.sqrt(tmp[0]* tmp[0] + tmp[1]*tmp[1]);
            }
        }
        return ans;
    }

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length -1, ans = -1;
        while (left <right) {
            int mid = (left + right)/2;

        }
        return ans;
    }
    public int compare(int[] nums, int l, int r) {

    }
    public static void main(String[] args) {
        int[][] aa = new int[][]{{200,0},{200,10}, {200,50},{200,30},{200, 25}};
        System.out.println(distance(aa));
    }


}
