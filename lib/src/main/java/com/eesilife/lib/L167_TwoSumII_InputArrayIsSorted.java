package com.eesilife.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by siy on 18-7-3.
 */
public class L167_TwoSumII_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int len = numbers.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            if (map.containsKey(numbers[i])){
                list.addAll(map.get(numbers[i]));
            }
            if (list.size() <= 1) {
                list.add(i);
                map.put(numbers[i], list);
            }
        }
        int temp;
        int t1 = -1;
        int t2 = -2;
        for (int i = 0; i < len - 1; i++) {
            if (target < numbers[i])break;
            temp = target - numbers[i];
            t1 = i + 1;
            if(map.containsKey(temp)){
                List<Integer> list = map.get(temp);
                if (list.size() == 1){
                    t2 = list.get(0) + 1;
                } else {
                    t2 = list.get(1) + 1;
                }
                break;
            }
        }
        result[0] = t1;
        result[1] = t2;
        return result;
    }
}
