package com.droider.interest;

/**
 * Create by siy on 21-1-4
 **/
class I004 {
    public static void main(String[] args) {
        System.out.println(ma(3, 20));
    }

    private static int ma(int m, int n) {
        int count = 0;
        int current = 1; // current 是当前长度
        while (n > current) {
            current += current < m ? current : m;
            count = count + 1;
        }
        return count;
    }
}
