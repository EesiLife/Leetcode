package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    public static void main(String[] args) {
//        productExceptSelf(new int[] {1,2,3,4});

//        divisibilityArray("8917171717276217174131", 17);

//        System.out.println(sumDistance(new int[]{-2,0,2}, "RLL", 3));
//        System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
        FrequencyTracker f = new  FrequencyTracker();
        f.hasFrequency(1);
        f.add(6);
        f.hasFrequency(1);
        f.add(2);
        f.add(6);
        f.add(5);
        f.hasFrequency(2);
        f.deleteOne(1);
        f.add(2);
        f.deleteOne(5);
        f.hasFrequency(1);
    }
}
