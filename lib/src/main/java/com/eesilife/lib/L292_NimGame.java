package com.eesilife.lib;

/**
 * Created by siy on 18-5-23.
 */
public class L292_NimGame {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        L292_NimGame c = new L292_NimGame();
        System.out.println(c.canWinNim(8));
    }

}
