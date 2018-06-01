package com.eesilife.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by siy on 18-5-30.
 */
public class L496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        List<Integer> list = new ArrayList<Integer>();
        for(int i : nums2){
            list.add(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int index = nums1[i];
            int j = list.indexOf(index);
            for (int k = j ; k < list.size(); k++){
                if (list.get(k) > index ){
                    result[i] = list.get(k);
                    break;
                } else {
                    result[i] = -1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
//        int[] nums1 = new int[]{4,1,2};
//        int[] nums2 = new int[]{1,3,4,2};
        int[] nums1 = new int[]{2,4};
        int[] nums2 = new int[]{1,2,3,4};
        L496_NextGreaterElementI c = new L496_NextGreaterElementI();
        System.out.println(Arrays.toString(c.nextGreaterElement(nums1,nums2)));
    }
}
