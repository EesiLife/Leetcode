package com.eesilife.lib;

import com.eesilif.lib.entity.GuessGame;

public class L374_GuessNumberHigherOrLower extends GuessGame{
    int sum = 0;
    public int guessNumber(int n) {
        int low=1;
        while(low<=n){
            int mid=low+(n-low)/2;
            int res=guess(mid);
            if(res==0)  return mid;
            else if(res==-1)    n=mid-1;
            else    low=mid+1;
        }
        return -1;
    }
}
