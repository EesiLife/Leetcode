package com.eesilife.lib;

import java.util.HashMap;

/**
 * Created by siy on 18-5-30.
 */
public class L013_RomanToInteger {
    public int romanToInt(String s) {
        int num = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            num += map.get(c);
            if (c == 'I') {
                if (i + 1 < s.length()) {
                    char next = s.charAt(i + 1);
                    if (next == 'V' || next == 'X') {
                        num -= map.get(c) *2;
                    }
                }
            } else if (c == 'X') {
                if (i + 1 < s.length()) {
                    char next = s.charAt(i + 1);
                    if (next == 'L' || next == 'C') {
                        num -= map.get(c) *2;
                    }
                }
            } else if (c == 'C') {
                if (i + 1 < s.length()) {
                    char next = s.charAt(i + 1);
                    if (next == 'D' || next == 'M') {
                        num -= map.get(c) *2;
                    }
                }
            }
        }
        return num;
    }
}
