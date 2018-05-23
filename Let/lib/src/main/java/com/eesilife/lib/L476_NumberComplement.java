package com.eesilife.lib;

/**
 * Created by siy on 18-5-23.
 */
public class L476_NumberComplement {
    public int findComplement(int num) {
        if (num < 0 || num > Integer.MAX_VALUE)return 0;
        String s = Integer.toBinaryString(num);
        String s1 = "";
        int len = s.length();
        int n = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                s1 += "1";
                n += (int) Math.pow(2, len - i -1);
            }
        }
        return n;
    }
    public static void main(String[] args){
        L476_NumberComplement c = new L476_NumberComplement();
        System.out.println(c.findComplement(1));
    }
}
