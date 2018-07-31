package com.eesilife.lib;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by siy on 18-7-31.
 */
public class L202_HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> add = new HashSet<>();
        while (n != 1 && !add.contains(n)) {
            add.add(n);
            String s = String.valueOf(n);
            int Sum = 0;
            for (int i = 0; i < s.length(); i++){
                int  intNum = s.charAt(i) - '0';
                Sum += Math.pow(intNum, 2);
            }
            n = Sum;
        }
        return n == 1;
    }
}
