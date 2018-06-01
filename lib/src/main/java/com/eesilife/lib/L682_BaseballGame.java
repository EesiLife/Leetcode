package com.eesilife.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siy on 18-5-30.
 */
public class L682_BaseballGame {
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            if ("C".equals(ops[i])) {
                int last = list.get(list.size() - 1);
                sum -= last;
                list.remove(list.size() - 1);
            } else if ("+".equals(ops[i])) {
                int last = list.get(list.size() - 1);
                int pre = list.get(list.size() - 2);
                int current = last + pre;
                list.add(current);
                sum += current;
            } else if ("D".equals(ops[i])) {
                int last = list.get(list.size() - 1);
                int current = last * 2;
                list.add(current);
                sum += current;
            } else {
                int current = Integer.parseInt(ops[i]);
                sum += current;
                list.add(current);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"5","2","C","D","+"};
        L682_BaseballGame c = new L682_BaseballGame();
        System.out.println(c.calPoints(s));
    }
}
