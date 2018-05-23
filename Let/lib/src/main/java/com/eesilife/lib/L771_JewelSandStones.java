package com.eesilife.lib;

public class L771_JewelSandStones {
    public int numJewelsInStones(String J, String S) {
        int sum = 0;
        if (null == J || J.length() == 0
                || null == S || S.length() == 0)
            return 0;
        for (int i = 0; i < S.length(); i ++) {
            if (J.contains(String.valueOf(S.charAt(i)))){
                sum += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        L771_JewelSandStones c = new L771_JewelSandStones();
        String J = "aA", S = "aAAbbbb";
        System.out.print(c.numJewelsInStones(J, S));
    }
}
