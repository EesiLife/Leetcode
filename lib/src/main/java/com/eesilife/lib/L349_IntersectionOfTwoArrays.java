package com.eesilife.lib;

import java.util.HashSet;

public class L349_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            int n1 = nums1[i];
            if(set.contains(n1))continue;
            for (int j = 0; j < nums2.length; j++) {
                if (n1 == nums2[j]) {
                    set.add(n1);
                    break;
                }
            }
        }
        if (set.size() >0) {
            Integer[] temp = set.toArray(new Integer[] {});
            int[] result = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                result[i] = temp[i].intValue();
            }
            return result;
        }else {
            return new int[]{};
        }
    }
}
