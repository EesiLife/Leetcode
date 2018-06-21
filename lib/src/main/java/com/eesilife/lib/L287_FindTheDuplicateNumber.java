package com.eesilife.lib;

import java.util.HashMap;

/**
 * Created by siy on 18-6-21.
 */
public class L287_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean isTarget = false;
        int tar = - 1;
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (map.get(t) == null) {
                map.put(t, 1);
            } else {
                tar = t;
                int a = map.get(t);
                map.put(t, a+1);
                break;
            }
        }
        return tar;
    }
}
