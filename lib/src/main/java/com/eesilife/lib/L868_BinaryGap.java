package com.eesilife.lib;

/**
 * Created by siy on 18-7-31.
 */
public class L868_BinaryGap {
    public int binaryGap(int N) {
        if(N < 1 || N > 1E9)return 0;
        String s = Integer.toBinaryString(N);
        int tep = -1;
        int max = 0;
        for (int i = 0; i< s.length(); i++ ){
            if (tep == -1 && s.charAt(i) == '1'){
                tep = i;
            }
            if(s.charAt(i) == '1'){
                max = Math.max(i - tep, max);
                tep = i;
            }
        }
        return max;
    }
}
