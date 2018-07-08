package com.eesilif.lib.entity;

public class GuessGame {
    int target = 6;
    public int guess(int num){
        if (num == target){
            return 0;
        }else if (num > target){
            return -1;
        } else {
            return 1;
        }
    }
}
