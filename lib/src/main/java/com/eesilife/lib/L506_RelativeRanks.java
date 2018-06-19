package com.eesilife.lib;

import java.util.Arrays;
import java.util.HashMap;

public class L506_RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new String[]{};
        } else if (nums.length == 1) {
            return new String[]{"Gold Medal"};
        }else if (nums.length == 2){
            int max = Math.max(nums[0], nums[1]);
            if (max == nums[0]) {
                return new String[]{"Gold Medal","Silver Medal"};
            } else {
                return new String[]{"Silver Medal","Gold Medal"};
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        String[] result = new String[len];
        for (int i = 0; i < len; i++){
            int target = map.get(nums[i]);
            if (i == len - 1) {
                result[target] = "Gold Medal";
            } else if (i == len - 2) {
                result[target] = "Silver Medal";
            } else if (i == len - 3){
                result[target] = "Bronze Medal";
            } else {
                result[target] = String.valueOf(len - i);
            }
        }
        return result;
    }
}
