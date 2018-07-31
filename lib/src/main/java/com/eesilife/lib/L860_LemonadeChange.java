package com.eesilife.lib;

/**
 * Created by siy on 18-7-31.
 */
public class L860_LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int n5 = 0;
        int n10 = 0;
        if(bills.length > 10000)return false;
        for(int i = 0; i < bills.length; i++){
            int current = bills[i];
            if(current == 5){
                n5++;
            } else if (current == 10){
                if(n5 == 0){
                    return false;
                } else {
                    n5--;
                    n10++;
                }
            } else if (current == 20){
                if(n5 == 0){
                    return false;
                } else if(n10 == 0){
                    if (n5 < 3){
                        return false;
                    } else {
                        n5-=3;
                    }
                }else {
                    n5--;
                    n10--;
                }
            }
        }
        return  true;
    }
}
