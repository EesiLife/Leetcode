package com.eesilife.lib;

/**
 * Created by siy on 18-7-9.
 */
public class L69_Sqrt_X {
    public int mySqrt(int x) {
        if(x == 0 || x == 1)return x;
        int lo = 1;
        int hi = x;
        int middle = 0;
        while(lo<=hi) {
            middle = lo + (hi - lo)/2;
            if(middle == x/middle) {
                return middle;
            } else {
                if (middle < x/middle) {
                    lo = middle + 1;
                } else {
                    hi = middle - 1;
                }
            }

        }
        return hi;
    }
}
