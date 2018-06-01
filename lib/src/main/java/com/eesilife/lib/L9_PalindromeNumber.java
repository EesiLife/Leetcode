package com.eesilife.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siy on 18-5-31.
 */
public class L9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int sum = 0;
        int n = x;
        while (n > 0) {
            int d = n % 10;
            sum = sum * 10 + d;
            n = n / 10;
        }
        return sum == x;
    }

    public int get(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum = sum * 10 + d;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        L9_PalindromeNumber c = new L9_PalindromeNumber();
        System.out.println(c.isPalindrome(121121));
    }
}
