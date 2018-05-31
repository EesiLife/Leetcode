package com.eesilife.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siy on 18-5-31.
 */
public class L766_ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        if (n == 1 || m == 1) return true;
        if (n == 2){
            if (matrix[0][0] != matrix[1][1]) return false;
            for (int i = 1; i < m; i++) {
                if (matrix[i][1] != matrix[i - 1][0])
                    return false;
            }
            return true;
        }
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> current = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (j != 0) current.add(matrix[i][j]);
                if (j != n - 1) temp.add(matrix[i][j]);
            }
            if (pre.size() == 0){
                pre.clear();
                pre.addAll(temp);
                continue;
            }
            if (pre.containsAll(current) && current.containsAll(pre)) {
                pre.clear();
                pre.addAll(temp);
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L766_ToeplitzMatrix c = new L766_ToeplitzMatrix();
//        int[][] matrix = new int[][]{{22,33,98},{34,20,65}};
        int[][] matrix = new int[][]{{41,45},{81,41},{73,81},{47,73},{0,47},{79,76}};
//        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(c.isToeplitzMatrix(matrix));
    }
}
