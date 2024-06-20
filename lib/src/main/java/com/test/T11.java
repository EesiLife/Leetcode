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
     * @param nums
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

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(4);
        TreeNode a2 = new TreeNode(8);
        TreeNode a = new TreeNode(6, a1, a2);
        TreeNode b1 = new TreeNode(12);
        TreeNode b2 = new TreeNode(16);
        TreeNode b = new TreeNode(14, b1, b2);
        TreeNode root = new TreeNode(10, a, b);
        T11 t = new T11();
        t.Convert(root);
        System.out.println(1);
    }

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

    public boolean isValidBST (TreeNode root) {
        // write code here
        if (root.left != null && root.right != null && (root.left.val >= root.val || root.right.val <= root.val)) {
             return false;
        } else if (root.left != null && (root.left.val >= root.val)) {
            return false;
        } else if (root.right != null && (root.right.val <= root.val)){
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean checkBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null) return root.left.val < root.val;
        if (root.right != null) return root.right.val > root.val;
        else return root.left.val < root.val && root.right.val > root.val;
    }

}
