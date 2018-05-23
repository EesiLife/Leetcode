package com.eesilife.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siy on 18-5-23.
 */
public class L728_SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list= new ArrayList<>();
        if (left < 0 || right > 10000)return list;
        for (int i = left; i <= right; i ++){
            String s = String.valueOf(i);
            if (s.contains("0"))continue;
            else {
                boolean isTarget = true;
                for (int j = 0; j < s.length(); j ++){
                    if (i % (s.charAt(j) - '0') != 0){
                        isTarget = false;
                        break;
                    }
                }
                if (isTarget)
                    list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args){
        L728_SelfDividingNumbers c = new L728_SelfDividingNumbers();
        System.out.println(c.selfDividingNumbers(1, 22));
    }
}
