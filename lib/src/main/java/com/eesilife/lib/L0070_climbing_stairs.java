package com.eesilife.lib;

/**
 * Create by siy on 20-1-17
 **/
public class L0070_climbing_stairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        int a1 = 1;
        int ans = 2;
        for (int i = 3; i <= n; i++) {
            int current = a1 + ans;
            a1 = ans;
            ans = current;
        }
        return ans;
    }

    public static void main(String[] args) {
        L0070_climbing_stairs ll = new L0070_climbing_stairs();
        System.out.println(ll.climbStairs1(3));
    }
}
