package com.eesilife.lib;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by siy on 18-5-23.
 */
public class L804_UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".",
                "..-.","--.","....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<String , Integer> dir = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        int len = words.length;
        for (int i = 0; i < len; i++){
            String s = words[i];
            String result = "";
            for (int j = 0; j < s.length(); j ++){
                int a = s.charAt(j) - 'a';
                result += morse[a];
            }
            set.add(result);
        }
        return set.size();
    }
    public static void main(String[] args) {
        L804_UniqueMorseCodeWords c = new L804_UniqueMorseCodeWords();
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(c.uniqueMorseRepresentations(words));
    }
}
