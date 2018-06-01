package com.eesilife.lib;

import java.util.ArrayList;
import java.util.List;

public class L136_SingleNumber {
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                list.remove((Integer) nums[i]);
            } else {
                list.add(nums[i]);
            }
        }
        return list.get(0);
    }
    public static void main(String[] args){
        int[] n = new int[]{2,2,1};
        int[] m = new int[]{4,1,2,1,2};
        L136_SingleNumber c = new L136_SingleNumber();
        System.out.print(c.singleNumber(m));
    }
}
