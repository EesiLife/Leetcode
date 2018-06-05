package com.eesilife.lib;

public class L844_BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        String s1 = "";
        String t1 = "";
        for (int i = 0; i < S.length(); i++){
            if (S.charAt(i) == '#') {
                if (s1.length() <= 1) {
                    s1 = "";
                } else {
                    s1 = s1.substring(0, s1.length() - 1);
                }
            } else {
                s1 += S.charAt(i);
            }
        }
        for (int i = 0; i < T.length(); i++){
            if (T.charAt(i) == '#') {
                if (t1.length() <= 1) {
                    t1 = "";
                } else {
                    t1 = t1.substring(0, t1.length() - 1);
                }
            } else {
                t1 += T.charAt(i);
            }
        }
        return s1.equals(t1);
    }

    public static void main(String[] args){
//        String S = "ab#c", T = "ad#c";
//        String S = "ab##", T = "c#d#";
//        String S="a##c", T= "#a#c";
        String S= "hd#dp#czsp#####", T= "hd#dp#cs#zspj######";
        L844_BackspaceStringCompare c = new L844_BackspaceStringCompare();
        System.out.print(c.backspaceCompare(S, T));
    }

}
