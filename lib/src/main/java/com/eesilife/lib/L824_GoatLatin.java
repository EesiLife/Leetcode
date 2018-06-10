package com.eesilife.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by siy on 18-6-8.
 */
public class L824_GoatLatin {
    public String toGoatLatin(String S) {
        if (null == S || "".equals(S)) return S;
        String result = "";
        //a, e, i, o, u
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('A');
        list.add('e');
        list.add('E');
        list.add('i');
        list.add('I');
        list.add('o');
        list.add('O');
        list.add('u');
        list.add('U');
        String[] s = S.split(" ");
        String temp = "";
        for (int i = 0; i < s.length; i++) {
            String ss = s[i];
            char start = ss.charAt(0);
            if (ss.length() == 1 || list.contains(start)) {
                temp = ss;
            } else {
                String ss1 = ss.substring(1, ss.length());
                String ss2 = ss1 + String.valueOf(start);
                temp = ss2;
            }
            for (int j = 0; j < i + 2; j++) {
                if (j == 0) {
                    temp += "ma";
                } else {
                    temp += "a";
                }
            }
            result += temp + " ";
        }
        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args){
        L824_GoatLatin c = new L824_GoatLatin();
//        String s = "I speak Goat Latin";
        String s = "The quick brown fox jumped over the lazy dog";
        System.out.println(c.toGoatLatin(s));
    }
}
