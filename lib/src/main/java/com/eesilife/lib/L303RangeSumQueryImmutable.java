package com.eesilife.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by siy on 18-6-5.
 */
public class L303RangeSumQueryImmutable {

    public class NumArray {
        private HashMap<String, Integer> map = new HashMap<>();
        private int[] arr;
        private int sum;
        public NumArray(int[] nums) {
            arr  = nums;
        }

        public int sumRange(int i, int j) {
            sum = 0;
            if (i > j)return 0;
            for (int k = i; k < j+1 ; k++){
                sum+= arr[k];
            }
            return sum;
        }
    }

    public static void main(String[] args){
//        int[] a = new int[]{0,1,2,3,4,5,6};
        int[] a = new int[]{-2, 0, 3, -5, 2, -1};
        L303RangeSumQueryImmutable c = new L303RangeSumQueryImmutable();
        L303RangeSumQueryImmutable.NumArray n = c.new NumArray(a);
        System.out.println(n.sumRange(2, 5));
    }
}
