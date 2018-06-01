package com.eesilife.lib;

/**
 * Created by siy on 18-5-24.
 */
public class L693_BinaryNumberWithAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        char[] s = Integer.toBinaryString(n).toCharArray();
        int len = s.length;
        boolean isTarget = true;
        for (int i = 0; i < len - 1; i++) {
            if (s[i] != s[i + 1]) {
                isTarget = true;
            } else {
                isTarget = false;
                break;
            }
        }
        return isTarget;
    }

    public static void main(String[] args) {
        L693_BinaryNumberWithAlternatingBits c = new L693_BinaryNumberWithAlternatingBits();
        System.out.println(c.hasAlternatingBits(7));
    }
}
