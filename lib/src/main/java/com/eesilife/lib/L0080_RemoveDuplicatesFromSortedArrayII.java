package com.eesilife.lib;

/**
 * Create by siy on 20-1-15
 **/
public class L0080_RemoveDuplicatesFromSortedArrayII {

    //80. 删除排序数组中的重复项 II
//    public int removeDuplicate(int[] nums) {
//        if (null == nums || nums.length == 0) return 0;
//        int j = 1;
//        int k = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != nums[i - 1]) {
//                nums[j] = nums[i];
//                j++;
//                k = 1;
//            } else if (k == 1) {
//                nums[j] = nums[i];
//                j++;
//                k = k + 1;
//            }
//        }
//        return j;
//    }

    //80. 删除排序数组中的重复项 II
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p1 = 0;
        int p2 = 1;
        int len = nums.length;
        while (p2 < len) {
            if (nums[p1] == nums[p2]) {
                if (p1 == 0 || nums[p1 - 1] != nums[p2]) {
                    p1++;
                    nums[p1] = nums[p2];
                    p2++;
                } else {
                    p2++;
                }

            } else {
                p1++;
                nums[p1] = nums[p2];
                p2++;
            }
        }
        return p1 + 1;
    }
}
