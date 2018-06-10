package com.eesilife.lib;

import java.util.ArrayList;
import java.util.List;

public class L389_FindTheDifference {
    public char findTheDifference(String s, String t) {
        char c  = ' ';
        List<Character> list = new ArrayList<>();
        for (char c1 :s.toCharArray())
            list.add(c1);
        for (int i = 0; i < t.length(); i++){
            if (list.contains(t.charAt(i))){
                char c2 = t.charAt(i);
                list.remove(new Character(c2));
            } else {
                return t.charAt(i);
            }
        }
        return c;
    }
    public static void main(String[] args){
        L389_FindTheDifference c = new L389_FindTheDifference();
        String s = "abcd";
        String t = "abcde";
        System.out.println(c.findTheDifference(s,t));
    }
}
