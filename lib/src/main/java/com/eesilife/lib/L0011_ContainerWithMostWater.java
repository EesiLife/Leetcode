package com.eesilife.lib;

/**
 * Create by siy on 20-7-7
 **/
public class L0011_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            System.out.println("i:" + i +";j:"+ j);
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
            System.out.println("---i:" + i +";j:"+ j + ";res:" + res);
        }
        return res;
    }

    public static void main(String[] args) {
        L0011_ContainerWithMostWater ll =new L0011_ContainerWithMostWater();
        int[] he = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(ll.maxArea(he));
    }
}
