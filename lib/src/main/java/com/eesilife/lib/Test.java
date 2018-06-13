package com.eesilife.lib;


import java.util.HashMap;
import java.util.Map;

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

        int[][] points = new int[][]{
                {0, 0}, {1, 0}, {2, 0}
        };
        System.out.println(t.numberOfBoomerangs(points));
    }

    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int m = points[0].length;
        int n = points.length;
        if (m != 2) return 0;
        if (n > 500)return 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int temp = 0;
            for (int j = 0; j < n; j++) {
                int x1 = points[j][0];
                int y1 = points[j][1];
                int ss = 0;
                temp = (x1 - x) * (x1 - x) + (y1 - y) * (y1 - y);
                if (map.get(temp)!= null &&map.get(temp) > 0) {
                    ss = map.get(temp) + 1;
                    map.put(temp, ss);
                } else {
                    map.put(temp, 1);
                }
            }
            System.out.println("i: " + i);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                int value = entry.getValue();
                if (value > 1) {
                    sum += (value - 1) * value;
                }
            }
            map.clear();
            System.out.println();
        }
        return sum;
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
                    sum += temp;
                }
            }
        }
        return sum;
    }
}
