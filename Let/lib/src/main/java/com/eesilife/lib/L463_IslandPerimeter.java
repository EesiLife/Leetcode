package com.eesilife.lib;

/**
 * Created by siy on 18-5-24.
 */
public class L463_IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || j == 0 ){

                    }
                }
            }
        }
        return 0;
    }

    public int getSum(int a, int b) {
        while(a != 0) {
            int tmp = (a & b) << 1;
            b = a ^ b;
            a = tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        L463_IslandPerimeter c = new L463_IslandPerimeter();
        int m =c.getSum(6,10);
        System.out.println(m);
    }
}
