package com.eesilife.lib;

/**
 * Create by siy on 20-1-16
 **/
public class L674_longest_continuous_increasing_subsequence {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (null == nums || nums.length == 0) return 0;
            int len = nums.length;
            int max = 1;
            int set = 0;//0表示相等,1递增,2递减
            for (int i = 1; i < len; i++) {
                if (nums[i] > nums[i - 1]) {
                    if (set <= 0) {
                        set = 2;
                    } else if (set > 0) {
                        set++;
                    }
                } else if (nums[i] < nums[i - 1]) {
                    if (set >= 0) {
                        set = -2;
                    } else if (set < 0) {
                        set--;
                    }
                } else {
                    set = 0;
                }
                max = Math.max(max, set);
            }
            return max;
        }
    }
}
