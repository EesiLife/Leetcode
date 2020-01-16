package com.eesilife.lib;

/**
 * Create by siy on 20-1-16
 **/
public class L61_add_binary {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        int lenA = a.length();
        int lenB = b.length();
        for (int i = lenA -1, j = lenB -1; i >=0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}
