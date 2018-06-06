package com.eesilife.lib;

import java.util.HashMap;

public class L20 {
    public boolean isValid(String s) {
        if ("".equals(s))return true;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int a = map.get(1);
                a += 1;
                if (a > 1) return false;
                map.put(1, a);
            } else if (s.charAt(i) == ')') {
                if (map.get(2) > 0 || map.get(3) > 0) {
                    return false;
                }
                int a = map.get(1);
                a -= 1;
                if (a < 0) return false;
                map.put(1, a);
            } else if (s.charAt(i) == '[') {
                int a = map.get(2);
                a += 1;
                if (a > 1) return false;
                map.put(2, a);
            } else if (s.charAt(i) == ']') {
                if (map.get(1) > 0 || map.get(3) > 0) {
                    return false;
                }
                int a = map.get(2);
                a -= 1;
                if (a < 0) return false;
                map.put(2, a);
            } else if (s.charAt(i) == '{') {
                int a = map.get(3);
                a += 1;
                if (a > 1) return false;
                map.put(3, a);
            } else if (s.charAt(i) == '}') {
                if (map.get(1) > 0 || map.get(2) > 0) {
                    return false;
                }
                int a = map.get(3);
                a -= 1;
                if (a < 0) return false;
                map.put(3, a);
            }
        }
        int a = map.get(1);
        int b = map.get(2);
        int c = map.get(3);
        return (a == 0 && b == 0 && c == 0);
    }

    public static void main(String[] args){
        L20 c = new L20();
//        String s = "([)]";
        String s = "{[]}";
//        String s = "()[]{}";
        System.out.println(c.isValid(s));
    }
}
