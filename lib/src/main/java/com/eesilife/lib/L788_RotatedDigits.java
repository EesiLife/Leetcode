package com.eesilife.lib;

/**
 * Created by siy on 18-6-21.
 */
public class L788_RotatedDigits {
    //788
    public int rotatedDigits(int N) {
        int result = 0;
        if (N <= 1 || N > 10000 )return result;
        for (int i = 1; i <  N + 1; i++) {
            String s = String.valueOf(i);
            if (s.contains("3") || s.contains("4") || s.contains("7"))continue;
            String a = s.replaceAll("1", "");
            String b = a.replaceAll("0", "");
            String c = b.replaceAll("8", "");
            if(c.length() == 0 || c.equals(""))continue;
            result++;
        }
        return result;
    }
}
