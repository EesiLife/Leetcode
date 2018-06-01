package com.eesilife.lib;

/**
 * Created by siy on 18-6-1.
 */
public class L258_AddDigits {
    public int addDigits(int num) {
        int sum = 0;
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++){
            int index = Integer.parseInt(String.valueOf(s.charAt(i)));
            int temp = sum + index;
            if (temp > 9) {
                int b = temp % 10;
                temp = temp / 10;
                sum = b + temp;
            } else {
                sum += index;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        L258_AddDigits c = new L258_AddDigits();
        System.out.println(c.addDigits(3118));
    }
}
