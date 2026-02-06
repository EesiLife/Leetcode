package com.ms100;

import java.util.HashMap;
import java.util.Map;

public class L5 {
    /**
     * 多数元素
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [3,2,3]
     * 输出：3
     * 示例 2：
     *
     * 输入：nums = [2,2,1,1,1,2,2]
     * 输出：2
     *
     *
     * 提示：
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -109 <= nums[i] <= 109
     * 输入保证数组中一定有一个多数元素。
     *
     *
     * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
     * @param nums
     * @return
     */

    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = -1, res = -1;
        for (Integer i : map.keySet()) {
            int val = map.get(i);
            if (max < val) {
                max = val;
                res = i;
            }
        }
        return res;
    }

    public static int majorityElement(int[] nums) {
        int count = 1, res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (res != nums[i]) {
                count--;
            } else {
                count++;
            }
            if (count == 0) {
                res = nums[i];
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {47,47,72,47,72,47,79,47,12,92,13,47,47,83,33,15,18,47,47,47,47,64,47,65,47,47,47,47,70,47,47,55,47,15,60,47,47,47,47,47,46,30,58,59,47,47,47,47,47,90,64,37,20,47,100,84,47,47,47,47,47,89,47,36,47,60,47,18,47,34,47,47,47,47,47,22,47,54,30,11,47,47,86,47,55,40,49,34,19,67,16,47,36,47,41,19,80,47,47,27};
        System.out.println(majorityElement(nums));
    }
}
