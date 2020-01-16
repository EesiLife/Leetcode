package com.eesilife.lib;

/**
 * Create by siy on 20-1-16
 **/
public class L66_plus_one {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean plus = false;
        for (int i = len -1; i >=0; i--) {
            int a = digits[i];
            if (a + 1 < 10) {
                digits[i] = a + 1;
                break;
            } else {
                digits[i] = 0;
                if (i == 0) {
                    plus = true;
                }
            }
        }
        if (plus) {
            int[] res = new int[len+1];
            for (int i = 0; i < len + 1; i ++) {
                if (i == 0) {
                    res[i] = 1;
                } else {
                    res[i] = digits[i -1];
                }
            }
            return res;
        }
        return digits;
    }
}
