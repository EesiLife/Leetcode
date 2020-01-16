package com.eesilife.lib;

/**
 * Create by siy on 20-1-16
 **/
public class L896_MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) return true;
        int set = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (set == 0) {
                    set++;
                } else if (set < 0) {
                    return false;
                }
            } else if (A[i] < A[i - 1]) {
                if (set == 0) {
                    set--;
                } else if (set > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
