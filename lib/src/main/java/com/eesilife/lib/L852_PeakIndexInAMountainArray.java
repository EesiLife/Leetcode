package com.eesilife.lib;

public class L852_PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        if(A.length < 3 || A.length > 10000){
            return -1;
        }
        int mid = -1;
        int len = A.length;
        int lo = 0;
        int hi = len - 1;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            int key = A[mid];
            if (key > A[mid - 1] && key > A[mid + 1]) {
                return mid;
            } else if (key > A[mid - 1] && key < A[mid + 1]) {
                lo = mid ;
            } else if (key < A[mid - 1] && key > A[mid + 1]) {
                hi = mid ;
            }
        }
        return mid;
    }
}
