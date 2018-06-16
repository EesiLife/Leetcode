package com.eesilife.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L599_MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {

        List<String> l1= Arrays.asList(list1);
        List<String> l2= Arrays.asList(list2);
        ArrayList<String> list = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        HashMap<Integer, Integer> mapL = new HashMap<>();
        int len = 0;
        for (String s : l1){
            if (l2.contains(s)) {
                len = s.length();
                int index = l1.indexOf(s) + l2.indexOf(s);
                if (null == mapL.get(len)) {
                    mapL.put(len, index);
                    list = new ArrayList<>();
                    list.add(s);
                    map.put(len, list);
                } else {
                    int indexO = mapL.get(len);
                    list = map.get(len);
                    if (index < indexO) {
                        list.clear();
                        list.add(s);
                        map.put(len, list);
                        mapL.put(len, index);
                    } else if (index == indexO) {
                        list.add(s);
                        map.put(len, list);
                    }
                }
            }
        }
        int min = -1;
        for (int key : mapL.keySet()){
            if (min == -1){
                min = mapL.get(key);
            }
            if (min > mapL.get(key)){
                min = mapL.get(key);
            }
        }
        List<Integer> lisKey = new ArrayList<>();

        for (int key : mapL.keySet()){
            if (mapL.get(key) == min) {
                lisKey.add(key);
            }
        }
        list = new ArrayList<>();
        for (int key : lisKey){
            list.addAll(map.get(key));
        }
        len = list.size();

        String[] array = new String[len];
        String[] result =list.toArray(array);
        return result;
    }
}
