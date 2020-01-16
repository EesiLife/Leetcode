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

    int mySqrt1(int x)
    {
        if(x == 1)
            return 1;
        int min = 0;
        int max = x;
        while(max-min>1)
        {
            int m = (max+min)/2;
            if(x/m<m)
                max = m;
            else
                min = m;
        }
        return min;
    }

    public int mySqrt2(int x) {
        if (x == 1 || x== 2) return 1;
        int y = x / 2;
        int left = 1;
        for (int i = 1; i <= y; i ++) {
            if (i < x / i) {
                left = i;
            } else if (i == x /i) {
                return i;
            } else {
                return left;
            }
        }
        return y;
    }
}
