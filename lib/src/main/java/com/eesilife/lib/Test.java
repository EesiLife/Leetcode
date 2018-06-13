package com.eesilife.lib;


/**
 * Created by siy on 18-5-28.
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(t.islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int temp = 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        temp--;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        temp--;
                    }
                    if (i + 1 < n && grid[i + 1][j] == 1) {
                        temp--;
                    }
                    if (j + 1 < m && grid[i][j + 1] == 1) {
                        temp--;
                    }
                    sum+=temp;
                }
            }
        }
        return sum;
    }
}
