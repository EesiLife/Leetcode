package com.eesilife.lib;

import java.util.HashMap;

/**
 * Created by siy on 18-6-1.
 */
public class L762_PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        int sum = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = L; i < R + 1; i++) {
            String s = Integer.toBinaryString(i);
            String s1 = s.replace("0", "");
            int number = s1.length();
            boolean isPrime = true;
            if (number == 1) {
                map.put(number, false);
            }
            if ( null != map.get(number)){
                isPrime = map.get(number);
                if (isPrime) {
                    sum++;
                }
            } else {
                for (int j = 2; j <= Math.sqrt(number); j++) {
                    if (number % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    sum++;
                }
                map.put(number, isPrime);
            }

        }
        return sum;
    }

    boolean isPrime(int number) {
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    public static void main(String[] args){
        L762_PrimeNumberOfSetBitsInBinaryRepresentation c = new L762_PrimeNumberOfSetBitsInBinaryRepresentation();
        System.out.println(c.countPrimeSetBits(1, 1));
    }
}
