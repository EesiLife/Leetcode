package com.eesilife.lib;

public class L0084_LargestTectangleInHistogram {


    public static int largestRectangleArea(int[] heights) {
        int  len = heights.length, res = 0;
        for (int i = 0; i < len; i++) {
            int height = heights[i];
            int j = i;
            int w = 1;
            while (--j > 0 && heights[j] >= height) {
                w++;
            }
            j = i;
            while (++j < len && heights[j] >= height) {
                w++;
            }
            System.out.println("current:" + height + ";w:" + w + ";res:" + res);
            res = Math.max(res, height * w);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] he = new int[]{2, 1, 5, 6, 2, 3};
        int[] he = new int[]{2, 1, 2};
        System.out.println(largestRectangleArea(he));
    }
}
