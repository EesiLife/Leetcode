package com.eesilife.lib;

public class L485_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                ++index;
            } else {
                if (index > max) {
                    max = index;
                }
                index = 0;
            }
        }
        if (index > max) max = index;
        return max;
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,1,0,1,1,1};
        L485_MaxConsecutiveOnes c = new L485_MaxConsecutiveOnes();
        System.out.print(c.findMaxConsecutiveOnes(nums));
    }
}
