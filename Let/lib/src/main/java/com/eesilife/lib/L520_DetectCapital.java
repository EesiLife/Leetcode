package com.eesilife.lib;

/**
 * Created by siy on 18-5-31.
 */
public class L520_DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1)return true;
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            if (word.charAt(1) >= 'A' && word.charAt(1) <= 'Z') {
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                        return false;
                    }
                }
            } else {
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                        return false;
                    }
                }
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L520_DetectCapital c = new L520_DetectCapital();
        String s = "isA";
        System.out.println(c.detectCapitalUse(s));
    }
}
