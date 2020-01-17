package com.eesilife.lib;

/**
 * Created by siy on 18-5-22.
 */
public class L0003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        String s1 = "";
        int max = 1;
        String item = "";
        for (int i = 0; i < s.length(); i++) {
            item = String.valueOf(s.charAt(i));
            if (i == 0) {
                s1 = item;
                item = "";
            } else {
                if (!s1.contains(item)) {
                    s1 += item;
                    if (s1.length() > max) {
                        max = s1.length();
                    }
                } else {
                    int index = s1.indexOf(item);
                    s1 = s1.substring(index + 1) + item;
                    if (s1.length() > max) {
                        max = s1.length();
                    }
                }
            }

        }
        return max;
    }

    public static void main(String[] args){
        String s = "abcabcbb";
        L0003_LongestSubstringWithoutRepeatingCharacters c = new L0003_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(c.lengthOfLongestSubstring(s));

    }
}
