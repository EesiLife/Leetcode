package com.eesilife.lib;

import com.eesilif.lib.entity.VersionControl;

/**
 * Created by siy on 18-7-10.
 */
public class L278FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int middle = lo + (hi - lo) / 2;
            if (isBadVersion(middle)) {
                if ((middle - 1) > 0) {
                    if (!isBadVersion(middle - 1)) {
                        return middle;
                    } else {
                        hi = middle - 1;
                    }
                }else {
                    return 1;
                }
            } else {
                if (middle < n ) {
                    if (isBadVersion(middle + 1)) {
                        return middle + 1;
                    } else {
                        lo = middle + 1;
                    }
                }else {
                    return middle;
                }
            }
        }
        return hi;
    }

    public static void main(String[] args){
        L278FirstBadVersion c = new L278FirstBadVersion();
        c.setFirstBadVersion(2147483647);
        System.out.println(c.firstBadVersion(2147483647));
    }
}
