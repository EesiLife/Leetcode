package com.eesilife.lib;

import java.util.Arrays;

/**
 * Created by siy on 18-5-23.
 */
public class L344_ReverseString {
    public String reverseString(String s) {
        char temp;
        char[] result = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len/2; i ++) {
            temp = result[i];
            result[i] = result[len - i - 1];
            result[len - i - 1] = temp;
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(new L344_ReverseString().reverseString("hello"));
    }
}
