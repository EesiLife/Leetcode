package com.test;

import java.util.*;

public class T10 {

    /**
     * 除自身以外数组的乘积
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     * 示例 2:
     *
     * 输入: nums = [-1,1,0,-3,3]
     * 输出: [0,0,9,0,0]
     *
     *
     * 提示：
     *
     * 2 <= nums.length <= 105
     * -30 <= nums[i] <= 30
     * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
     *
     *
     * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
     */
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            if (i== 0) {
                ans[i] = 1;
            } else {
                ans[i] = ans[i - 1] * nums[i - 1];
            }
        }
        int R = 1;
        for (int i = len -1 ; i >= 0; i--) {
            ans[i] = ans[i] *R;
            R *= nums[i];
        }
        return ans;
    }

    /**
     * 134. 加油站
     * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     *
     * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
     * 示例 1:
     * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
     * 输出: 3
     * 解释:
     * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
     * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
     * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
     * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
     * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
     * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
     * 因此，3 可为起始索引。
     * 示例 2:
     *
     * 输入: gas = [2,3,4], cost = [3,4,3]
     * 输出: -1
     * 解释:
     * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
     * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
     * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
     * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
     * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
     * 因此，无论怎样，你都不可能绕环路行驶一周。
     * 提示:
     * gas.length == n
     * cost.length == n
     * 1 <= n <= 105
     * 0 <= gas[i], cost[i] <= 104
     */
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//
//    }

    /**
     * 找出字符串的可整除数组
     * 中等
     * 给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
     *
     * word 的 可整除数组 div  是一个长度为 n 的整数数组，并满足：
     *
     * 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
     * 否则，div[i] = 0
     * 返回 word 的可整除数组。
     *
     *
     *
     * 示例 1：
     *
     * 输入：word = "998244353", m = 3
     * 输出：[1,1,0,0,0,1,1,0,0]
     * 解释：仅有 4 个前缀可以被 3 整除："9"、"99"、"998244" 和 "9982443" 。
     * 示例 2：
     *
     * 输入：word = "1010", m = 10
     * 输出：[0,1,0,1]
     * 解释：仅有 2 个前缀可以被 10 整除："10" 和 "1010" 。
     *
     *
     * 提示：
     *
     * 1 <= n <= 105
     * word.length == n
     * word 由数字 0 到 9 组成
     * 1 <= m <= 109
     */
    public static int[] divisibilityArray(String word, int m) {
        int len = word.length();
        int[] ans = new int[len];
        long cur = 0;
        for (int i = 0; i < len; i++) {
            cur = (cur * 10 + (word.charAt(i) - '0'))% m;
            if (cur == 0) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }

    public static long findTheArrayConcVal(int[] nums) {
        int i = 0, j = nums.length - 1;
        long sum = 0;
        while (i < j) {
            sum += Long.parseLong(nums[i] + String.valueOf(nums[j]));
            i++;
            j--;
        }
        if (i== j) sum+= nums[i];
        return sum;
    }

    public static int sumDistance(int[] nums, String s, int d) {
        int MOD = 1000000007;
        long ans = 0;
        long[] step = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (s.charAt(i) == 'L') {
                step[i] = (long)nums[i] - d;
            } else {
                step[i] = (long)nums[i] + d;
            }
        }
        Arrays.sort(step);
        for (int i = 1; i < nums.length; i++) {
            ans += 1L * (step[i] - step[i -1]) * i % MOD * (nums.length - i)%MOD;
            ans %= MOD;
        }
        return (int)ans;
    }

    public int minimumPossibleSum(int n, int target) {
        final int MOD = (int) 1e9 + 7;
        int m = target / 2;
        if (n <= m) {
            return (int) ((long) (1 + n) * n / 2 % MOD);
        }
        return (int) (((long) (1 + m) * m / 2 +
                ((long) target + target + (n - m) - 1) * (n - m) / 2) % MOD);
    }

    public static String capitalizeTitle(String title) {
        StringBuilder ans = new StringBuilder();
        String[] arr = title.split(" ");
        for (String s : arr) {
            if (ans.length() != 0) {
                ans.append(" ");
            }
            if (s.length() > 2) {
                ans.append(Character.toUpperCase(s.charAt(0)));
                s = s.substring(1);
            }
            ans.append(s.toLowerCase());
        }
        return ans.toString();
    }

    public static long maxArrayValue(int[] nums) {

        int sum = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                sum+= nums[i];
            } else {
                ans = Math.max(ans, sum);
                sum = nums[i];
            }
        }
        ans = Math.max(ans, sum);
        return ans;
    }

    private static String testPath(String path) {
        if (path.startsWith("/mnt/user/")) {
            String tmp = path.replace("/mnt/user/", "");
            int i = tmp.indexOf('/');
            if (i != -1) {
                path = "/storage" + tmp.substring(i);
            } else {
                path = path.replace("/mnt/user/0/", "/storage/");
            }
        }
        return path;
    }

    class NumArray {
        int[] sum;
        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sum[right + 1] - sum[left];
        }
    }

    public static int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int left = k -1, right = k + 1;
        for (int i = nums[k];; i--) {
            while (left >= 0 && nums[left] >=i) {
                left--;
            }
            while (right < n && nums[right] >=i) {
                right++;
            }
            ans = Math.max((right - left - 1) * i, ans);
            if (left == -1 && right == n) {
                break;
            }
        }
        return ans;
    }

    static class FrequencyTracker {
        HashMap<Integer, Integer> map;
        HashMap<Integer, Integer> mapFrequency;

        public FrequencyTracker() {
            map = new HashMap<>();
            mapFrequency = new HashMap<>();
        }

        public void add(int number) {
            Integer cnt = map.get(number);
            if (cnt == null) {
                map.put(number, 1);
                Integer fre = mapFrequency.get(1);
                mapFrequency.put(1, null == fre ? 1 : ++fre);
            } else {
                Integer fre = mapFrequency.get(cnt);
                mapFrequency.put(fre, --fre);
                int newCnt = ++cnt;
                map.put(number, newCnt);
                fre = mapFrequency.get(newCnt);
                mapFrequency.put(newCnt, fre == null ? 1 : ++fre);
            }
        }

        public void deleteOne(int number) {
            Integer cnt = map.get(number);
            if (cnt == null || cnt == 0) return;
            Integer fre = mapFrequency.get(cnt);
            mapFrequency.put(cnt, --fre);
            int newCnt = --cnt;
            map.put(number, newCnt);
            fre = mapFrequency.get(newCnt);
            mapFrequency.put(newCnt, fre == null ? 1 : ++fre);
        }

        public boolean hasFrequency(int frequency) {
            Integer val = mapFrequency.get(frequency);
            if (null == val || 0 == val) return false;
            return true;
        }
    }

//    public int minNonZeroProduct(int p) {
//
//    }

    public static String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();i++) {
            if (s.charAt(i) == i) {
                sb = sb.reverse();
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q== null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int a = columnNumber / 0;
            columnNumber = columnNumber % v;
            sb.append((char) ('A' + a - 1));
        }
        if (columnNumber != 0) {
            sb.append((char) ('A' + columnNumber - 1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(2147483647));
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
        for (int i = 0; i < intervals.length;i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merge.size() == 0 || merge.get(merge.size() - 1)[1] < L) {
                merge.add(new int[]{L, R});
            } else {
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], R);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }

    public int countWays1(int[][] ranges) {
        int MOD = 1000000007;
        int ans = 1;
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        List<int[]> merge = new ArrayList<>();
        for (int i = 0; i < ranges.length;i++) {
            int L = ranges[i][0], R = ranges[i][1];
            if (merge.size() == 0 || merge.get(merge.size() - 1)[1] < L) {
                merge.add(new int[]{L, R});
                ans = ans * 2 % MOD;
            } else {
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], R);
            }
        }
        return ans;
    }

    //2580
    public int countWays(int[][] ranges) {
        int MOD = 1000000007;
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int ans = 1;
        int maxR = -1;
        for (int i = 0; i < ranges.length;i++) {
            int L = ranges[i][0], R = ranges[i][1];
            if (maxR < L) {
                ans = ans * 2 % MOD;
            }
            maxR = Math.max(maxR, R);
        }
        return ans;
    }

    /**
     * 2963统计好分割方案的数目
     * @param nums
     * @return
     */
    public static int numberOfGoodPartitions(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length;i++) {
            int x = nums[i];
            if (map.containsKey(x)) {
                map.get(x)[1] = i;
            } else {
                map.put(x, new int[]{i, i});
            }
        }
        int ans = 1;
        List<int[]> list = new ArrayList<>(map.values());
        list.sort((p,q)-> p[0] - q[0]);
        int maxR = list.get(0)[1];
        for (int i = 1; i < list.size(); i++) {
            int L = list.get(i)[0], R = list.get(i)[1];
            if (L > maxR) {
                ans = ans * 2 % 1_000_000_007;
            }
            maxR = Math.max(maxR, R);
        }
        return ans;
    }

    //1997
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int mod = 1000000007;
        int len = nextVisit.length;
        int[] dp = new int[len];

        dp[0] = 2; //初始化原地待一天 + 访问下一个房间一天
        for (int i = 1; i < len; i++) {
            int to = nextVisit[i];
            dp[i] = 2 + dp[i - 1];
            if (to != 0) {
                dp[i] = (dp[i] - dp[to - 1] + mod) % mod; //避免负数
            }

            dp[i] = (dp[i] + dp[i - 1]) % mod;
        }
        return dp[len - 2]; //题目保证n >= 2
    }
//    public static void main(String[] args) {
////        productExceptSelf(new int[] {1,2,3,4});
//
////        divisibilityArray("8917171717276217174131", 17);
//
////        System.out.println(sumDistance(new int[]{-2,0,2}, "RLL", 3));
////        System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
////        FrequencyTracker f = new  FrequencyTracker();
////        f.hasFrequency(1);
////        f.add(6);
////        f.hasFrequency(1);
////        f.add(2);
////        f.add(6);
////        f.add(5);
////        f.hasFrequency(2);
////        f.deleteOne(1);
////        f.add(2);
////        f.deleteOne(5);
////        f.hasFrequency(1);
//        numberOfGoodPartitions(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,23});
//    }
}
