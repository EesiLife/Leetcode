package com.eesilife.lib;

import java.util.ArrayList;
import java.util.List;

public class L026_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0)return 0;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int len = 0;
        for (int i = 1; i < nums.length; i++){
            len = list.size();
            if (!list.contains(nums[i])){
                list.add(nums[i]);
            }
            if (list.size() > len){
                int index = list.size() - 1;
                nums[index] = list.get(index);
            }
        }
        return list.size();
    }

    public static void main(String[] args){
        L026_RemoveDuplicatesFromSortedArray c = new L026_RemoveDuplicatesFromSortedArray();
//        int[] nums = new int[]{1, 1, 2};
//        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] nums = new int[]{-3,-1,0,0};
        System.out.println(c.removeDuplicates(nums));
    }
}
