package com.eesilife.lib;

import com.test.T5;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by siy on 20-1-16
 **/
public class L989_add_to_array_form_of_integer {
    //989
    public List<Integer> addToArrayForm2(int[] A, int K) {
        int lenA = A.length;
        String k = String.valueOf(K);
        int lenK = k.length();
        int ca = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = lenA - 1, j = lenK -1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? A[i] : 0;
            sum += j >= 0 ? k.charAt(j) - '0' : 0;
            ans.append(sum % 10);
            ca = sum / 10;
        }
        ans.append(ca == 1 ? ca : "");
        String s = ans.reverse().toString();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
        return result;
    }

    public List<Integer> addToArrayForm1(int[] A, int K) {
        String a = "";
        for (int i = 0; i < A.length; i++) {
            a +=A[i];
        }
        String b = String.valueOf(K);
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        int lenA = a.length();
        int lenB = b.length();
        for (int i = lenA -1, j = lenB -1; i >=0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 10);
            ca = sum / 10;
        }
        ans.append(ca == 1 ? ca : "");
        String s = ans.reverse().toString();
        System.out.println(s);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
        return result;
    }
    public List<Integer> addToArrayForm(int[] A, int K) {
        long a = 0;
        for (int i = A.length -1; i >=0; i--) {
            a += A[i] * Math.pow(10, A.length -1 -i);
        }
        long c = a + K;
        String s = String.valueOf(c);
        System.out.println(s);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            ans.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
        return ans;
    }
    public static void main(String[] args) {
//        int[] A = new int[]{1,2,0,0};int  K = 34;
//        int[] A = new int[]{2,7,4};int K = 181;
//        int[] A = new int[]{2,1,5};int K = 806;
        int[] A = new int[]{9,9,9,9,9,9,9,9,9,9};int K = 1;
        System.out.println(new T5().addToArrayForm2(A,K));
    }
}
