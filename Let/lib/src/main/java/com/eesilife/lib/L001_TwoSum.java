package com.eesilife.lib;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by siy on 18-5-22.
 */
public class L001_TwoSum {
    public static void main(String[] args){
        twoSum(new int[]{2, 7, 11, 15}, 9);
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            if (map.get(gap) != null && map.get(gap) != i) {
                res[0] = i;
                res[1] = map.get(gap);
                break;
            }
        }
        for (int i = 0; i <= res.length - 1; i++) {
            System.out.print(res[i] + ";\n");
        }
        return res;
    }
}
