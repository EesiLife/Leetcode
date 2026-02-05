package com.ms100;

public class L1 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int[] ret = new int[len];
        int i = 0, j = 0, k = 0;
        while (i < m || j < n) {
            if (i < m && j < n) {
                int left = nums1[i];
                int right = nums2[j];
                if (left <= right) {
                   ret[k] = left;
                   i++;
                } else {
                    ret[k] = right;
                    j++;
                }
            } else if ( i < m) {
                ret[k] = nums1[i];
                i++;
            } else if (j < n) {
                ret[k] = nums2[j];
                j++;
            } else {
                break;
            }
            k++;
        }
        for (int l = 0; l < len; l++) {
            nums1[l] = ret[l];
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,0,0,0};
        int m = 3, n = 3;
        int[] num2 = new int[] {2,5,6};
        merge(num1, m, num2, n);
    }

}
