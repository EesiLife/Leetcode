package com.eesilife.lib;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by siy on 20-1-16
 **/
public class L697_DegreeOfAnArray {

    static class Item {
        int startIndex;
        int endIndex;
        int cnt;
    }

    public int findShortestSubArray1(int[] nums) {
        Map<Integer, Item> map = new HashMap<>();
        int arrDu = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            Item item = map.get(nums[i]);
            if (item == null) {
                item = new Item();
                item.startIndex = item.endIndex = i;
                item.cnt = 1;
                map.put(nums[i], item);
            } else {
                item.endIndex = i;
                item.cnt++;
            }
            arrDu = Math.max(arrDu, item.cnt);
        }

        int ans = nums.length;
        for (Map.Entry<Integer, Item> entry : map.entrySet()) {
            Item item = entry.getValue();
            if (item.cnt == arrDu) {
                ans = Math.min(item.endIndex - item.startIndex + 1, ans);
            }
        }
        return ans;
    }


    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> list = new HashMap<>();
        HashMap<Integer, Integer[]> ll = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (null == list.get(nums[i])) {
                list.put(nums[i], 1);
            } else {
                int tmp = list.get(nums[i]);
                tmp++;
                list.put(nums[i], tmp);
            }

            if (null == ll.get(nums[i])) {
                Integer[] i1 = new Integer[]{-1, -1};
                i1[0] = i;
                ll.put(nums[i], i1);
            } else {
                Integer[] i2 = ll.get(nums[i]);
                i2[1] = i;
                ll.put(nums[i], i2);
            }
        }
        int max = 0, step = 0;
        for (Integer i : list.keySet()) {
            if (list.get(i) > max) {
                max = list.get(i);
                Integer[] steps = ll.get(i);
                step = steps[1] - steps[0];
            } else if (list.get(i) == max) {
                Integer[] steps = ll.get(i);
                int step_cur = steps[1] - steps[0];
                if (step > step_cur) {
                    max = list.get(i);
                    step = step_cur;
                }
            }
        }
        return step <= 0 ? 1 : step + 1;
    }
}
