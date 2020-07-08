package com.eesilife.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by siy on 20-7-7
 **/
public class L0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (null == nums || nums.length < 3) return null;
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] >0) break;
            if (i > 0 && nums[i] == nums[i - 1])continue;
            int L = i + 1, R = len -1;
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
                    R --;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        L0015_3Sum ll = new L0015_3Sum();
        System.out.println(ll.threeSum(nums));
    }
}
