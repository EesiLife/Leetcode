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
//        System.out.println(c.myPow3(2.00000, -2147483648));
//        System.out.println((System.currentTimeMillis() - time) / 1000);

        System.out.println(c.isAnagram("", ""));
//        System.out.println(c.isAnagram("aab", "aac"));
    }

    public int findContentChildren(int[] g, int[] s) {

        for (int i = 0; i < s.length; i++) {
//            for (int j = 0; j < g.length; j++){
//                if (s[i] > = )
//            }
        }
        return 0;
    }

    public boolean isAnagram(String s, String t) {
        if (s == t)return true;
        for (int i = 0; i < s.length() - 1; i++) {
            String a = String.valueOf(s.charAt(i+1)) + String.valueOf(s.charAt(i));
            if (t.contains(a))
                return true;
        }
        return false;
    }
}
