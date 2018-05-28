package com.eesilife.lib;

/**
 * Created by siy on 18-5-28.
 */
public class L821_ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        int len = S.length();
        int[] result = new int[len];
        String[] ss = S.split(String.valueOf(C));
        int index = 0;
        for (int i = 0; i < ss.length - 1; i++) {
            if (i == 0) {
                for(int j = 0; j < ss[i].length() - 1; j++) {
                    result[index] = ss[i].length() - j;
                }
                index += ss[i].length();
            }
//            result[index] =
        }
        for (int i = 0; i < len - 1; i++) {
            if (S.charAt(i) == C) {
                result[i] = 0;
            } else {
                result[i] = i + 1;
            }
        }

        return result;
    }
}
