package com.eesilife.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by siy on 18-5-30.
 */
public class L566_ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] result = new int[r][c];
        int m = nums[0].length;
        int n = nums.length;
        if (r * c != m * n)
            return nums;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                list.add(nums[i][j]);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++){
                result[i][j] = list.get(0);
                list.remove(0);
            }
        }
        return result;
    }

    public static void main(String[] args){
        L566_ReshapeTheMatrix c = new L566_ReshapeTheMatrix();
        int[][] nums = new int[][]{{1,2},{3,4}, {5,6}};
        int[][] result = new int[3][2];
        result = c.matrixReshape(nums, 2, 3);
    }
}
