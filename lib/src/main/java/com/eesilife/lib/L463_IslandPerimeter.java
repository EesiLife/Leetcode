package com.eesilife.lib;

/**
 * Created by siy on 18-5-24.
 */
public class L463_IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int sum = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    sum++;
                }
            }
        }
        if (sum == m * n){
            return 2*(m + n);
        }
        return 2 * sum + 2;
    }

    public static void main(String[] args) {
        L463_IslandPerimeter c = new L463_IslandPerimeter();
//        int[][]  grid = new int[][]{{0,1,0,0},
//                {1,1,1,0},
//                {0,1,0,0},
//                {1,1,0,0}};
        int[][] grid = new int[][]{
                {1,1},{1,1}
        };
        System.out.println(c.islandPerimeter(grid));
    }
}
