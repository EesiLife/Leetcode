package com.eesilife.lib;

/**
 * Created by siy on 18-7-24.
 */
public class L709_ToLowerCase {
    public String toLowerCase(String str) {
        char[] c = str.toCharArray();
        String result = "";
        for (int i = 0; i < c.length; i++){
            if (c[i]>= 65 && c[i] <= 90){
                c[i] = Character.toLowerCase(c[i]);
            }
            result+= String.valueOf(c[i]);
        }
        return result;
    }

    public static void main(String[] args){
        String s = "HelLo";
        L709_ToLowerCase c = new L709_ToLowerCase();
        System.out.println(c.toLowerCase(s));
    }
}
