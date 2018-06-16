package com.eesilife.lib;

public class L598_RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        if (null == ops || ops.length == 0)return m*n;
        int len = ops.length;
        int maxA = ops[0][0];
        int maxB = ops[0][1];
        for (int i = 0; i < len; i++) {
            int a = ops[i][0];
            int b = ops[i][1];
            if ( a <= maxA){
                maxA = a;
            }
            if (b <= maxB){
                maxB = b;
            }
        }
        return maxA * maxB;
    }
}
