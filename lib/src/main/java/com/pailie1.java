package com;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by siy on 18-8-7.
 */
public class pailie1 {
    static int k = 0;
    static HashSet<char[]> set = new HashSet<char[]>();
    static ArrayList<Character> list = new ArrayList<Character>();

    public boolean isSwap(char[] num, int i, int j) {
        for (int index = i; index < j; index++) {
            if (num[index] == num[j])
                return false;
        }
        return true;
    }

    public void p(char[] array, int index) {
        char temp;

        if (index < 0 || index > array.length) {
            return;
        }
        if (index == array.length) {
            System.out.println(array);
            k++;
        }
        for (int j = index; j < array.length; j++) {
            if (isSwap(array, index, j)) {
                temp = array[j];
                array[j] = array[index];
                array[index] = temp;
                p(array, index + 1);
                temp = array[j];
                array[j] = array[index];
                array[index] = temp;

            } else {
                continue;
            }

        }


    }

    public static void main(String[] args) {
        String s = "12234";
        char[] c = s.toCharArray();
        pailie1 pailie = new pailie1();
        pailie.p(c, 0);
        System.out.println(k);


    }


}
