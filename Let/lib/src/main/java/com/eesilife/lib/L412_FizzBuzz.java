package com.eesilife.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siy on 18-5-30.
 */
public class L412_FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i ++){
            if (i  < 3 || i == 4) {
                list.add(String.valueOf(i));
                continue;
            }
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public static void main(String[] args){
        L412_FizzBuzz c = new L412_FizzBuzz();
        System.out.println(5%3);
        System.out.println(c.fizzBuzz(16));
    }
}
