package com.eesilife.lib;

import java.util.HashMap;

/**
 * Created by siy on 18-5-30.
 */
public class L575_DistributeCandies {
    public int distributeCandies(int[] candies) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : candies){
            int index = 0;
            if (null != map.get(i)){
                index += map.get(i);
            }
            map.put(i, index++);
        }
        int len = candies.length / 2;
        return map.size() > len ? len : map.size();
    }

    public int distributeCandies1(int[] candies) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < candies.length; i++) {
            if (map.size() == candies.length/2) {
                break;
            }
            int index = 0;
            if (null != map.get(i)){
                index += map.get(i);
            }
            map.put(candies[i], index++);
        }
        return map.size();
    }

    public static void main(String[] args){

    }
}
