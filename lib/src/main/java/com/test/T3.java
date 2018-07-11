package com.test;

public class T3 {
    public static void main(String[] args) {
        T3 c = new T3();
        int[] n = new int[]{2,3,4,5,1};
        System.out.println(c.findMin(n));
    }

    //153
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length;
        if (hi == 1) return nums[0];
        if(hi == 2) return Math.min(nums[0], nums[1]);
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int middle = nums[mid];
            if (mid == 0)return nums[0];
            if (mid == nums.length - 1)return nums[mid];
            int low = nums[mid - 1];
            int high = nums[mid + 1];
            if (low > middle && high > middle){
                return  middle;
            } else {
                if (low < middle && middle > high){
                    lo = mid;
                } else {
                    hi = mid;
                }

            }

        }

        return nums[hi];
    }
}
