package com.eesilife.lib;

import java.util.Arrays;

/**
 * Created by siy on 18-5-28.
 */
public class L821_ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        int len = S.length();
        System.out.println(len);
        int[] result = new int[len];
        String[] ss = S.split(String.valueOf(C));
        System.out.println(ss.length);
        System.out.println(Arrays.toString(ss));
        int index = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].length() == 0){
                index++;
                continue;
            }
            if (i == 0) {
                if (S.startsWith(String.valueOf(C))) {
                    index++;
                    for(int j = 0; j < (ss[i].length() + 1) / 2; j++) {
                        result[index] = j + 1;
                        result[index + ss[i].length() - j - 1 -j] = j + 1;
                        index++;
                    }
                    index += ss[i].length()/2;
                } else {
                    for(int j = 0; j < ss[i].length(); j++) {
                        result[index] = ss[i].length() - j;
                        index++;
                    }
                    index++;
                }
            } else if (i == ss.length - 1) {
                if (S.lastIndexOf(String.valueOf(C)) == S.length() - 1 ) {
                    for(int j = 0; j < (ss[i].length() + 1) / 2; j++) {
                        result[index] = j + 1;
                        result[index + ss[i].length() - j - 1 -j] = j + 1;
                        index++;
                    }
                    index += ss[i].length()/2;
                } else {
                    for(int j = 0; j < ss[i].length(); j++) {
                        result[index] = j + 1;
                        index++;
                    }
                    index++;
                }
            } else {
                for(int j = 0; j < (ss[i].length() + 1) / 2; j++) {
                    result[index] = j + 1;
                    result[index + ss[i].length() - j - 1 -j] = j + 1;
                    index++;
                }
                index += ss[i].length()/2 + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String S = "rzazolgxogbmcjjievdt";
        char C = 'g';
        L821_ShortestDistanceToACharacter c = new L821_ShortestDistanceToACharacter();
        System.out.println(Arrays.toString(c.shortestToChar(S, C)));
        System.out.println(new String ("[6, 5, 4, 3, 2, 1, 0, 1, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]"));
    }
}
