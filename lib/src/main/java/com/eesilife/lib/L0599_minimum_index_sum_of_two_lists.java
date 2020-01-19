package com.eesilife.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by siy on 20-1-19
 **/
public class L0599_minimum_index_sum_of_two_lists {
    public static class Item{
        public int index1, sum = -1;
    }
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Item> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            Item item = new Item();
            item.index1 = i;
            map.put(list1[i], item);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                Item item = map.get(list2[i]);
                item.sum = item.index1 + i;
                map.put(list2[i], item);
            }
        }
        List<String> tmp = new ArrayList<>();
        int min = -1;
        for (String key : map.keySet()) {
            Item item = map.get(key);
            if (item.sum == -1) continue;
            if (min == -1) {
                tmp.add(key);
                min = item.sum;
            } else {
                if (min > item.sum) {
                    tmp.clear();
                    min = item.sum;
                    tmp.add(key);
                } else if (min == item.sum){
                    tmp.add(key);
                }
            }
        }
        String[] ans = new String[tmp.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = tmp.get(i);
        }
        return ans;
    }

    public String[] findRestaurant1(String[] list1, String[] list2) {
        if(list1.length>list2.length) return findRestaurant(list2, list1);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list2.length && i <= min; i++) { // less execute in loop i <= min
            if (map.containsKey(list2[i])) {
                int sum = i + map.get(list2[i]);
                if (sum < min) {
                    res.clear();
                    min = sum;
                    res.add(list2[i]);
                } else if (min == sum)
                    res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
