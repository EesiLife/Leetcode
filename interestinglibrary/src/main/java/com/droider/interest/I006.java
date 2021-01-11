package com.droider.interest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by siy on 21-1-4
 **/
class I006 {
    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 2; i < 10000; i += 2) {
            check(ans, i);
        }
        System.out.println(Arrays.toString(ans.toArray()));
    }

    private static void check(List<Integer> ans, int i) {
        int target = i;
        i = i * 3 + 1;
        while (i != 1) {
            if (i % 2 == 0) {
                i = i / 2;
                if (i == target) {
                    ans.add(i);
                    System.out.println(target);
                    break;
                }
            } else {
                i = i * 3 + 1;
            }
        }
    }
}
