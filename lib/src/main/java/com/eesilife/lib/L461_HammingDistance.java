package com.eesilife.lib;

public class L461_HammingDistance {

    public int hammingDistance(int x, int y) {
        if (x < 0 || x > Integer.MAX_VALUE
        || y < 0 || y > Integer.MAX_VALUE)
            return 0;
        int z = x ^ y;
        System.out.println(z);
        String s = Integer.toBinaryString(z);
        System.out.println(s);
        int sum = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1'){
                sum += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        L461_HammingDistance c = new L461_HammingDistance();
        System.out.println(c.hammingDistance(1, 4));
    }

}
