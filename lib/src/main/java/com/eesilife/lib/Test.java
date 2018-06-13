package com.eesilife.lib;


import java.util.HashMap;
import java.util.HashSet;
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
//        System.out.println(Arrays.toString(t.numberOfBoomerangs(points)));

        //
        int[] num1= new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] result = t.intersection(num1, nums2);
        for (int i = 0; i <result.length; i++)
            System.out.println(result[i]);
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

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            int n1 = nums1[i];
            if(set.contains(n1))continue;
            for (int j = 0; j < nums2.length; j++) {
                if (n1 == nums2[j]) {
                    set.add(n1);
                    break;
                }
            }
        }
        if (set.size() >0) {
            Integer[] temp = set.toArray(new Integer[] {});
            int[] result = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                result[i] = temp[i].intValue();
            }
            return result;
        }else {
            return new int[]{};
        }

    }
}
