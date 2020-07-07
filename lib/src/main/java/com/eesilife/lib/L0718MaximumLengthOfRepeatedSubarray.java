package com.eesilife.lib;

/**
 * Create by siy on 20-7-2
 **/
public class L0718MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = m -1; i >= 0; i--) {
            for (int j = n -1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,2,1};
        int[] B = new int[]{3,2,1,4,7};
        System.out.println(new L0718MaximumLengthOfRepeatedSubarray().findLength(A, B));
    }
}
