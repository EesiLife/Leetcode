package com.eesilife.lib;

import java.util.HashMap;
import java.util.Map;

public class L447_NumberOfBoomerangs {
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
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int value = entry.getValue();
                if (value > 1) {
                    sum += (value - 1) * value;
                }
            }
            map.clear();
        }
        return sum;
    }
}
