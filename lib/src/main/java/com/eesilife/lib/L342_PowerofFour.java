package com.eesilife.lib;

public class L342_PowerofFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0)return false;
        while (num > 0) {
            if (num == 1)return true;
            int n = num % 4;
            if (n > 0 )return false;
            num /= 4;
        }
        return true;
    }
}
