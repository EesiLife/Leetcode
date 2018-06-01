package com.eesilife.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            int[] m = new int[i + 1];
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j < (i+2) /2; j++) {
                if (j == 0) {
                    m[j] = m[i - j] = 1;
                } else{
                    m[j] = m[i -j] = pre.get(j - 1) + pre.get(j);
                }
            }
            pre.clear();
            for (int index :m){
                pre.add(index);
                current.add(index);
            }
            list.add(current);
        }
        return list;
    }

    public static void main(String[] args) {
        L118_PascalsTriangle c = new L118_PascalsTriangle();
        c.generate(5);
    }

}
