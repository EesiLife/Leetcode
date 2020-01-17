package com.eesilife.lib;

/**
 * Create by siy on 20-1-17
 **/
public class L125_valid_palindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 97 && s.charAt(i) <= 122) || (s.charAt(i) >= 48 && s.charAt(i) <= 57)) {
                ans += String.valueOf(s.charAt(i));
            }
        }
        if ("".equals(ans)) return true;
        int len = ans.length() / 2;
        for (int i = 0; i < len; i++) {
            if (ans.charAt(i) != ans.charAt(ans.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
