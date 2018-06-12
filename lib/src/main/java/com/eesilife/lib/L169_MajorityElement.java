package com.eesilife.lib;

import java.util.HashMap;

/**
 * Created by siy on 18-6-12.
 */
public class L169_MajorityElement {
    public int majorityElement(int[] nums) {
        if (null == nums || nums.length == 0)return 0;
        int len = nums.length;
        int target = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++){
            int temp = 0;
            if (null != map.get(nums[i])) {
                temp = map.get(nums[i]);
            }
            temp++;
            map.put(nums[i], temp);
            if (temp > len/2){
                target = nums[i];
                break;
            }
        }
        return target;
    }

    public static void main(String[] args){
        L169_MajorityElement c = new L169_MajorityElement();
        int[] n = new int[]{3,2,3};
        System.out.println(c.majorityElement(n));
    }
}
