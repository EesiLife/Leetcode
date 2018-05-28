package com.eesilife.lib;

import java.util.Arrays;

/**
 * Created by siy on 18-5-28.
 */
public class Test {
    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';
        String[] ss = S.split(String.valueOf(C));
        System.out.println(ss.length);
        System.out.println(Arrays.toString(ss));
    }
}
