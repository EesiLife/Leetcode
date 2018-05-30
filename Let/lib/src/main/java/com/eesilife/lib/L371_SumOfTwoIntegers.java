package com.eesilife.lib;

/**
 * Created by siy on 18-5-30.
 */
public class L371_SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while(a != 0) {
            int tmp = (a & b) << 1;
            b = a ^ b;
            a = tmp;
        }
        return b;
    }
}
