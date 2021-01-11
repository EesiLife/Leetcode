package com.droider.interest;

/**
 * Create by siy on 21-1-4
 **/
class I005 {
    public static void main(String[] args) {
        int[] coins = new int[]{10, 50, 100, 500};
        int[] maxCounts = new int[5];
        int target = 1000;
        int tMax = 15;
        for (int i = 0; i < coins.length; i++) {
            int num = target / coins[i];
            maxCounts[i] = num > tMax ? tMax : num;
        }
    }
}
