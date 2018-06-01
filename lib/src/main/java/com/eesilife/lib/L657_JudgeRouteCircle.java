package com.eesilife.lib;

public class L657_JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        if (null == moves || moves.length() == 0) return false;
        int a = 0, b = 0;
        int len = moves.length();
        for (int i = 0; i < len; i++) {
            if (moves.charAt(i) == 'L') {
                a += 1;
            } else if (moves.charAt(i) == 'R') {
                a -= 1;
            } else if (moves.charAt(i) == 'U') {
                b += 1;
            } else if (moves.charAt(i) == 'D') {
                b -= 1;
            } else {
                return false;
            }
        }
        if (0 == a && b == 0) return true;
        return false;
    }

    public static void main(String[] args){
        L657_JudgeRouteCircle c = new L657_JudgeRouteCircle();
        String s = "LDRRLRUULR";
        System.out.print(c.judgeCircle(s));
    }

}
