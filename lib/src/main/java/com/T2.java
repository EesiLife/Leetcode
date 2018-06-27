package com;

import java.util.Stack;

public class T2 {
    public double myPow(double x, int n) {
        if (n < 0)
            return 1 / x * myPow(1 / x, -(n + 1));
        else if (n == 0)
            return 1;
        else if (n == 1)
            return x;

        double half = myPow(x, n >> 1);
        half *= half;

        if ((n & 1) == 1)
            half *= x;
        return half;
    }

    double myPow3(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return myPow3(1 / x, -(n + 1)) / x;
        Stack<Integer> s = new Stack<Integer>();
        for (; n != 1; n /= 2)
            s.push(n);
        double t = x;
        while (!s.isEmpty()) {
            t *= t;
            if (s.pop() % 2 != 0)
                t *= x;
        }
        return t;
    }

    public static void main(String[] args) {
        T2 c = new T2();
        long time = System.currentTimeMillis();
//        System.out.println(c.myPow(0.00001, 2147483647));
//        System.out.println(c.myPow(-2.00000, 2));
        System.out.println(c.myPow3(2.00000, -2147483648));
        System.out.println((System.currentTimeMillis() - time) / 1000);
    }
}
