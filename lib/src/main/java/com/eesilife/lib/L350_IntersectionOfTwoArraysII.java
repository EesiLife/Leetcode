package com.eesilife.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by siy on 18-7-6.
 */
public class L350_IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> l2 = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int len2 = nums2.length;
        for(int i = 0; i < len2; i++){
            l2.add(nums2[i]);
        }
        int len1 = nums1.length;
        for (int i = 0; i < len1; i++){
            if (l2.contains(nums1[i])){
                int temp = 0;
                if (null != map.get(nums1[i])){
                    temp = map.get(nums1[i]);

                }
                temp++;
                map.put(nums1[i], temp);
                l2.remove(new Integer(nums1[i]));
            }
        }
        List<Integer> result = new ArrayList<>();
        for(Integer key : map.keySet()){
            for (int i = 0; i < map.get(key); i++) {
                result.add(key);
            }
        }
        int[] re = new int[result.size()];
        for (int i = 0; i < re.length; i++){
            re[i] = result.get(i);
        }
        return re;
    }
}
