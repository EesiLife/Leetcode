package com.eesilife.lib;

import java.util.Stack;

/**
 * Created by siy on 18-6-27.
 */
public class L0050Pow_x_n {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return myPow(1 / x, -(n + 1)) / x;
        Stack<Integer> s = new Stack<Integer>();
        for (; n != 1; n /= 2){
            s.push(n);
            System.out.println(n);
        }
        double t = x;
        while (!s.isEmpty()) {
            t *= t;
            if (s.pop() % 2 != 0)
                t *= x;
        }
        return t;
    }
    public static void main(String[] args){
        L0050Pow_x_n c = new L0050Pow_x_n();
        long time = System.currentTimeMillis();
//        System.out.println(c.myPow(0.00001, 2147483647));
//        System.out.println(c.myPow(-2.00000, 2));
        System.out.println(c.myPow(2.00000, 777));
        System.out.println((System.currentTimeMillis() - time) / 1000);
    }
}
