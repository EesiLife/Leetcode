package com;

/**
 * Created by siy on 18-12-27.
 */
public class Test {
    public static void main(String[] arg) {
        Boolean b = null;
        System.out.print("b==null:" + (b == null));
        b = new Boolean(false);
        System.out.print("b==null:" + (b == null));
        System.out.print("b==null:" + (b.booleanValue()));
    }
}