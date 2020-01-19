package com.eesilife.lib;

import java.util.Arrays;

/**
 * Create by siy on 20-1-19
 **/
public class L0189_rotate_array {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        if (k == 0) return;
        int kk = k % nums.length;
        if (kk == 0) return;
        for (int i = 0; i < kk; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }
}
