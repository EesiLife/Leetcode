package com.eesilife.lib;

/**
 * Create by siy on 20-1-16
 **/
public class L058_length_of_last_word {
    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                len++;
            } else if (len != 0) {
                return len;
            }
        }
        return len;
    }
}
