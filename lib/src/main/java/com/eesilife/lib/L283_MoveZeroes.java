package com.eesilife.lib;

public class L283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums != null) {
            int length = nums.length;
            for (int i = 0, j = 0; i < length; i++) {
                if (nums[i] != 0) {
                    if (i != j) {
                        nums[j] = nums[i];
                        nums[i] = 0;
                    }
                    j++;
                }
            }
        }
    }
}
