package com.eesilife.lib;

import java.util.Arrays;

/**
 * Created by siy on 18-5-24.
 */
public class L557_ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String[] array = s.split(" ");
        int len = array.length;
        String[] array_out = new String[len];
        String result = "";
        for (int i = 0; i < len; i ++) {
            char[] in = array[i].toCharArray();
            int n = in.length;
            int mLen = n / 2;
            char temp;
            for (int j = 0; j < mLen; j ++) {
                temp = in[n - j - 1];
                in[n - j - 1] = in[j];
                in[j] = temp;
            }
            String res = "";
            for (int j = 0; j < n; j ++) {
                res += String.valueOf(in[j]);
            }
            array_out[i] = res;
        }
        for (int i = 0; i < len; i++) {
            result += array_out[i] + " ";
        }
        return result.substring(0, result.length());
    }

    public static void main(String[] args) {
        System.out.println(new L557_ReverseWordsInAStringIII().reverseWords("Let's take LeetCode contest"));
    }
}
