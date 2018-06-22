package com.eesilife.lib;

/**
 * Created by siy on 18-6-22.
 */
public class L191_NumberOf1Bits {
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int result = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1'){
                result++;
            }
        }
        return result;
    }
}
