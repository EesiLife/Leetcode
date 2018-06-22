package com.eesilife.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by siy on 18-6-21.
 */
public class L041_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums== null || nums.length == 0)return 1;
        if (nums.length == 1) {
            int a = nums[0];
            return a == 1 ? 2 : 1;
        }
        int min = nums[0];
        int max = nums[0];
        boolean minIsOne = false;
//        if (min == 1 || max == 1){
//            minIsOne = true;
//        }
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (min <= 0 || max <= 0) {
                min = max = nums[i];
            }
            if (index > 0) {
                if (index <= min){
                    if (index == 1){
                        minIsOne = true;
//                        min = 2;
                    } else {
                        min = index;
                    }
                } else{
                    if (minIsOne && index + 1 == min){
                        min = index;
                    }
                }
                if (index > max) max = index;
            }
        }
        System.out.println("min: " + min);
        System.out.println("max: " + max);
        if (minIsOne) {
            if (max == 1) {
                return 2;
            } else if (min == 1) {
                if (max == 2){
                    return 3;
                }
                return 2;
            }
            if (max == 2){
                return 3;
            } else if (min == 2){
                return 3;
            } else {
                return min - 1;
            }
        }
        return 1;
    }

    public int firstMissingPositive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        if (nums.length == 1) {
            if (nums[0] <= 0 || nums[0] >= 2)return 1;
            if (nums[0] == 1)return 2;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums){
            list.add(i);
        }
        int minA = 1;
        int max = 1;
        for (int i = 0; i < nums.length; i++){
            int index = nums[i];
            if (index > 0 && index == minA) {
                minA = index + 1;
                if (list.contains(minA)){
                    minA++;
                }
            }
            if (max < index){
                max = index;
            }
        }
        int minB = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            int index = nums[i];
            if (index > 0 && index == minB) {
                minB = index + 1;
                if (list.contains(minB)){
                    minB++;
                }
            }
        }
        System.out.println("minA: " + minA + " - minB: "+ minB);
        int min = minA > minB ? minA : minB;
        if (min == max){
            min++;
        }
        return min;
    }

    public static void main (String[] args){
        int[] num = new int[]{3,4,-1,1};//2 min:2 max: 4
        int[] a = new int[]{1,2,0};//3 min:1 max: 2
        int[] b = new int[]{7,8,9,11,12};//1 min:7 max: 12
        int[] d = new int[]{1,0};//2
        int[] e = new int[]{2,2};//1
        int[] f = new int[]{1,1000};//2
        int[] g = new int[]{0,1,2};//3
        int[] h = new int[]{1,2,5};//3
        int[] j = new int[]{2, 1};//3
        int[] k = new int[]{};//1
        int[] l = new int[]{4,1,2,3};//5
        int[] m = new int[]{0,2,2,4,0,1,0,1,3};// 5
        int[] n = new int[]{7,2,2,2,-7,8,8,3,3,5,-1,18,-1,-3,-7,-9,8,1,4};
        L041_FirstMissingPositive c = new L041_FirstMissingPositive();
        System.out.println(c.firstMissingPositive1(n));
    }
}
