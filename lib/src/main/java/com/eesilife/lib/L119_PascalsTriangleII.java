package com.eesilife.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siy on 18-5-31.
 */
public class L119_PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i < rowIndex+1; i++) {
            int[] m = new int[i + 1];
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j < (i+2) /2; j++) {
                if (j == 0) {
                    m[j] = m[i - j] = 1;
                } else{
                    m[j] = m[i -j] = pre.get(j - 1) + pre.get(j);

            }
            pre.clear();
            for (int index :m){
                pre.add(index);
                current.add(index);
            }
            list.add(current);
        }
        return list.get(list.size() -1);
    }

    public static void main(String[] args) {
        L118_PascalsTriangle c = new L118_PascalsTriangle();
        c.generate(5);
    }
}
