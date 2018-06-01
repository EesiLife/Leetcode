package com.eesilife.lib;

import java.util.Arrays;

/**
 * Created by siy on 18-5-24.
 */
public class L561_ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2){
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        L561_ArrayPartitionI c = new L561_ArrayPartitionI();
        int[] nums = new int[]{1,4,3,2,4,4};
        System.out.println(c.arrayPairSum(nums));
    }
}
