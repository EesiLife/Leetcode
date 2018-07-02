package com.eesilife.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siy on 18-7-2.
 */
public class L744_FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        List<Character> list = new ArrayList<>();
        for (char c : letters){
            if (!list.contains(c))
                list.add(c);
        }
        char[] arr = new char[list.size()];
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        char min = arr[0], max = arr[arr.length - 1];
        if (target < min || target >= max) return min;
        int mid = -1;
        int len = arr.length;
        int lo = 0;
        int hi = len - 1;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            char key = arr[mid];
            if (lo + 1 == hi) {
                return arr[hi];
            }
            if (key > target) {
                hi = mid;
            } else if (key < target) {
                lo = mid ;
            } else {
                return arr[mid+ 1];
            }
        }
        return arr[mid];
    }
}
