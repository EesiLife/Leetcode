package com.eesilife.lib;

import java.util.Arrays;

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

    public void te(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length;i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        L283_MoveZeroes ll = new L283_MoveZeroes();
        int[] a = new int[]{0,1,0,3,12};
        ll.te(a);
    }
}
