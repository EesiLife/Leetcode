package com.eesilife.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by siy on 18-5-24.
 */
public class L500_KeyboardRow {
    public String[] findWords(String[] words) {
        List<String> out = new ArrayList<>();
        String[] s = new String[]{"zxcvbnm", "asdfghjkl", "qwertyuiop"};
        for (int i = 0; i < words.length; i++) {
            int index;
            String word = words[i].toLowerCase();
            if (s[0].contains(String.valueOf(word.charAt(0)))) {
                index = 0;
            } else if (s[1].contains(String.valueOf(word.charAt(0)))) {
                index = 1;
            } else {
                index = 2;
            }
            for (int j = 1; j < word.length(); j++) {
                String a = String.valueOf(word.charAt(j));
                if (!s[index].contains(a)) {
                    index = -1;
                    break;
                }
            }
            if (index != -1) {
                out.add(words[i]);
            }
        }
        String[] result = new String[out.size()];
        for (int i = 0; i < out.size(); i++)
            result[i] = out.get(i);
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(new L500_KeyboardRow().findWords(words)));
    }
}
