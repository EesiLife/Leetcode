package com.eesilife.lib;

import java.util.Arrays;

/**
 * Created by siy on 18-5-28.
 */
public class Test {
    public static void main(String[] args) {
        String s = "discuss.leetcode.com";
        String[] a = s.split("\\.");
        System.out.println(s);
        System.out.println(Arrays.toString(a));
    }
}
