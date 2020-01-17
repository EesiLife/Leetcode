package com.eesilife.lib;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by siy on 20-1-17
 **/
public class L0137_single_number_ii {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }
}
