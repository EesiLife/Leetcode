package com.eesilife.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by siy on 18-6-21.
 */
public class L645_SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int target = -1;
        for (int i = 1; i < len + 1; i++){
            list.add(i);
        }
        for (int i = 0; i < len; i++){
            int index = nums[i];
            list.remove(new Integer(index));
            if (map.get(index) == null) {
                map.put(index, 1);
            } else {
                target = index;
            }
        }
        return new int[]{target, list.get(0)};
    }
}
