package com.eesilife.lib;

public class L0007_ReverseInteger {
    public int reverse(int x) {
        long xx= (long)x;
        long y = 0;
        long z = 0;
        if(x < 0){
            y = Math.abs(xx);
        }else{
            y = xx;
        }
        String s1 = String.valueOf(y);
        String s2 = new StringBuilder(s1).reverse().toString();
        z = Long.parseLong(s2);
        if(x < 0){
            z = 0 - z;
        }
        if(z > Integer.MAX_VALUE || z < Integer.MIN_VALUE){
            return 0;
        }
        int k = (int)z;
        return k;
    }

    public static void main(String[] args){
        L0007_ReverseInteger c = new L0007_ReverseInteger();
        System.out.println(c.reverse(-20));
    }
}
