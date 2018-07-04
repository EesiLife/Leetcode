package com.eesilife.lib;

/**
 * Created by siy on 18-7-4.
 */
public class L367_ValidPerfectSquare {

    public static void main(String[] args){
        L367_ValidPerfectSquare c = new L367_ValidPerfectSquare();
        System.out.println(c.isPerfectSquare(6));
    }

    public boolean isPerfectSquare(int num) {
        for(int i = 1; num > 0; i += 2){
            num -= i;
        }
        return num == 0;
    }
}
