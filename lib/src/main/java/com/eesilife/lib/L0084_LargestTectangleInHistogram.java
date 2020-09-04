package com.eesilife.lib;

import java.util.ArrayDeque;
import java.util.Deque;

public class L0084_LargestTectangleInHistogram {


    public static int largestRectangleArea(int[] heights) {
        int len = heights.length, res = 0;
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

    public static int largestRectangleArea1(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) new_heights[i] = heights[i - 1];
        //System.out.println(Arrays.toString(new_heights));
        for (int i = 0; i < new_heights.length; i++) {
            //System.out.println(stack.toString());
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] he = new int[]{2, 1, 5, 6, 2, 3};
//        int[] he = new int[]{2, 1, 2};
        System.out.println(largestRectangleArea(he));
    }
}
