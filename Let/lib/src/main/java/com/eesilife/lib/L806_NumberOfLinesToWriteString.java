package com.eesilife.lib;

import java.util.Arrays;
import java.util.HashMap;

public class L806_NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int len = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < widths.length; i++){
            map.put((char)(97 + i), widths[i]);
        }
        int len_row = 0;
        int mLen = 0;
        for (int i = 0; i < S.length(); i++) {
            mLen = map.get(S.charAt(i));
            if (len_row + mLen > 100) {
                len_row = 0;
                len += 1;
            }
            len_row += mLen;
        }
        int[] result = new int[]{len, len_row};
        return result;
    }

    public static void main(String[] args){
//        int[] widths = new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
//        String S= "bbbcccdddaaa";

        int[] widths = new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String S = "abcdefghijklmnopqrstuvwxyz";
        L806_NumberOfLinesToWriteString c = new L806_NumberOfLinesToWriteString();
        System.out.print(Arrays.toString(c.numberOfLines(widths, S)));

    }
}
