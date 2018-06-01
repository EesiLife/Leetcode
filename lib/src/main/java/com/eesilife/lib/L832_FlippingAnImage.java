package com.eesilife.lib;

import java.util.Arrays;

/**
 * Created by siy on 18-5-23.
 */
public class L832_FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] B = new int[A[0].length][A.length];
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2 + 1; j++) {
                int t1 = A[i][j];
                int t2 = A[i][n - j - 1];
                if (t2 == 0) {
                    B[i][j] = 1;
                } else {
                    B[i][j] = 0;
                }
                if (t1 == 0) {
                    B[i][n - j - 1] = 1;
                } else {
                    B[i][n - j - 1] = 0;
                }
                System.out.println(String.format("i=%d,j=%d,t1=%d,t2=%d,B[i=%d][j=%d]=%d,B[i=%d][n-j-1=%d]=%d",
                        i, j, t1, t2, i, j ,B[i][j], i, (n-j-1),B[i][n - j - 1]));
            }
        }
        return B;
    }

    public static void main(String[] args) {
        L832_FlippingAnImage c = new L832_FlippingAnImage();
//        int[][] A = new int[][]{{1, 1, 0}, {0, 1, 1}, {1, 0, 1}};
        int[][] A = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        for (int i = 0; i < A.length; i++)
            System.out.println(Arrays.toString(A[i]));
        int[][] B = c.flipAndInvertImage(A);
        System.out.println();
        for (int i = 0; i < B.length; i++)
            System.out.println(Arrays.toString(B[i]));
    }
}
