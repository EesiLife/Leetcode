package com.eesilife.lib;

/**
 * Created by siy on 18-5-24.
 */
public class L171_ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        char[] c = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < c.length; i++){
            int a = c[i] - 64;
            sum += a * (int)Math.pow(26, (c.length - i - 1));
        }
        return sum;
    }

    public static void main(String[] args){

    }
    public  void js2local(String s ) {

    }
}
