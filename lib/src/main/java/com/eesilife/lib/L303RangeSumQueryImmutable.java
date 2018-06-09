package com.eesilife.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by siy on 18-6-5.
 */
public class L303RangeSumQueryImmutable {

    public class NumArray {
        private int[] arr;

        public NumArray(int[] nums) {
            arr = nums;
            for (int i = 1; i < nums.length; i++) {
                arr[i] = arr[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if (i > j || i < 0 || j < 0 || j >= arr.length) return 0;
            return i == 0 ? arr[j] : (arr[j] - arr[i - 1]);
        }
    }

    public static void main(String[] args) {
//        int[] a = new int[]{0,1,2,3,4,5,6};
        int[] a = new int[]{-2, 0, 3, -5, 2, -1};
        L303RangeSumQueryImmutable c = new L303RangeSumQueryImmutable();
        L303RangeSumQueryImmutable.NumArray n = c.new NumArray(a);
        System.out.println(n.sumRange(0, 5));
    }
}
