package com.eesilife.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siy on 18-6-21.
 */
public class L268_MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>(len+1);
        for (int i = 0; i < len+1; i++){
            list.add(i);
        }
        for (int i : nums){
            if (list.contains(i)){
                list.remove(new Integer(i));
            }
        }
        return list.get(0);
    }
}
