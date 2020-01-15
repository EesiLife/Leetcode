package com.eesilife.lib;

public class L035_SearchInsertPosition {
    //35
    public int searchInsert(int[] nums, int target) {
        if (nums == null ||nums.length == 0)return 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= target) {
                return i;
            }
        }
        if(index == -1)return nums.length;
        return -1;
    }

    public int searchInsert1(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target)
                high = mid - 1;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                return mid;
        }
        return low;
    }
}
