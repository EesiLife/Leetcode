package com.eesilife.lib;


import java.util.ArrayList;
import java.util.List;

public class L027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0)return 0;
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == val){
                list.add(i);
                index++;
            } else {
                if (list.size() > 0){
                    nums[list.get(0)] = nums[i];
                    list.remove(list.get(0));
                    list.add(i);
                } else {
                    int temp = i - index;
                    nums[temp] = nums[i];
                }
            }
        }
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
        return nums.length - index;
    }

    public static void main(String[] args){
        L027_RemoveElement c = new L027_RemoveElement();
//        int[] nums = new int[]{0,1,2,2,3,0,4,2};
//        int[] nums = new int[]{3,2,2,3};
//        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int[] nums = new int[]{0,4,4,0,4,4,4,0,2};
        System.out.println(c.removeElement(nums, 4));

    }
}
