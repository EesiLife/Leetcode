package com.eesilife.lib;

/**
 * Create by siy on 20-1-19
 **/
public class L1317_convert_integer_to_the_sum_of_two_no_zero_integers {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int num = n - i;
            if (!String.valueOf(i).contains("0")
                    && !String.valueOf(num).contains("0")) {
                return new int[]{i, num};
            }
        }
        return null;
    }
}
