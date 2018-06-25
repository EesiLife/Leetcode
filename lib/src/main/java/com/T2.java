package com;

public class T2 {
    public double myPow(double x, int n) {
        double re = 1.0000;
        if (n > 0){
            for(int i = 0; i < n; i ++){
                re *= x;
            }
        } else if (n < 0){
            int n1 = 0 - n;
            for(int i = 0; i < n1; i ++){
                re *= x;
            }
        }
        System.out.println(String.format("%.5f", re));
        String s = String.format("%.5f", re);
        double r = Double.parseDouble(s);
        return (double) Math.round(re*100000)/100000 ;
    }

    public static void main(String[] args){
        T2 c = new T2();
        System.out.println(c.myPow(2.10000, 3));
    }
}
