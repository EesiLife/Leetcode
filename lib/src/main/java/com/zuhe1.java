package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by siy on 18-8-7.
 */
public class zuhe1 {
    static int k = 0;
    static HashSet<String> set;

    public void p(char[] arrays, int begin, int number, ArrayList<Character> list) {
        if (number == 0) {
//    		System.out.println(list.toString());
            k++;
            set.add(list.toString());
            return;
        }
        if (begin == arrays.length) {
            return;
        }

        list.add(arrays[begin]);
        p(arrays, begin + 1, number - 1, list);
        list.remove((Character) arrays[begin]);
        p(arrays, begin + 1, number, list);
    }

    public static void main(String[] args) {
        String s = "1223";
        char[] arrays = s.toCharArray();
        zuhe1 zuhe1 = new zuhe1();
        ArrayList<Character> list = new ArrayList<Character>();
        for (int number = 1; number < arrays.length + 1; number++) {
            set = new HashSet<String>();
            zuhe1.p(arrays, 0, number, list);
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String a = it.next();
                System.out.println(a);
            }
        }
    }
}


