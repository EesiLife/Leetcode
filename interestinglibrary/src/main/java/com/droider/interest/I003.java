package com.droider.interest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by siy on 21-1-4
 **/
class I003 {

    public static void main(String[] args) {
        boolean[] start = new boolean[100];
        for (int i = 2; i < 100; i++) {
            int index = i;
            if (index >= 100) break;
            for (int j = index - 1; j < 100; j+= i) {
                start[j] = !start[j];
                if(j == 99) {
                    System.out.println("i:" + i + ";start[99]:" +start[99]);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (!start[i]) {
                ans.add(i + 1);
            }
        }
        System.out.println(Arrays.toString(ans.toArray()));
    }

}
