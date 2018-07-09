package com.eesilife.lib;

import java.util.Arrays;

/**
 * Created by siy on 18-7-9.
 */
public class L628_Maximum_Product_of_Three_Numbers {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int n1 = 0, n2 = 1, nmax = len - 1;
        int n3 = len - 2, n4 = len - 3;
        int m1 = nums[n1] * nums[n2] * nums[nmax];
        int m2 = nums[n3] * nums[n4] * nums[nmax];
        return  m1 > m2 ? m1 : m2;
    }
}
