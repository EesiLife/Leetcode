package com.eesilife.lib;

import java.util.Arrays;

/**
 * Create by siy on 20-1-16
 **/
public class L611_valid_triangle_number {
    public int triangleNumber(int[] nums) {
        if (null == nums || nums.length <= 2) return 0;
        int res = 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        System.out.println("{" + i + "," + j + "," + k + "}," + "{" + nums[i] + "," + nums[j] + "," + nums[k] + "}");
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public int triangleNumber1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                int s = nums[i] + nums[j];
                int l = j + 1, r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >>> 1;
                    if (nums[mid] < s) l = mid;
                    else r = mid - 1;
                }
                if (nums[r] < s) {
                    res += r - j;
                }
            }
        }
        return res;
    }

}
