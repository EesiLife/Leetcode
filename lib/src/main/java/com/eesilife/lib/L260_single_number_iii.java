package com.eesilife.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by siy on 20-1-17
 **/
public class L260_single_number_iii {
    public int[] singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                list.remove((Integer) nums[i]);
            } else {
                list.add(nums[i]);
            }
        }
        int[] ans = new int[2];
        ans[0] = list.get(0);
        ans[1] = list.get(1);
        return ans;
    }
}
