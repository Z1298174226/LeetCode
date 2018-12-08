package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/12/11.
 */

//O(log(m+n))
public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    public static double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k/2, B, bStart,       k - k/2);
        else
            return getkth(A, aStart,       B, bStart + k/2, k - k/2);
    }

    public static double findMedianSortedArraysII(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int l = (len1 + len2 + 1) / 2;
        int r = (len1 + len2 + 2) / 2;
        int i = 1; int j = 1;
        int[] num = new int[len1 + len2];
        while(i + j <= r) {
            if(A[i - 1] >= B[j - 1])  {
                num[i + j - 2] = B[j - 1];
                j++;
            }
            else {
                num[i + j - 2] = A[i - 1];
                i++;
            }
        }
        if(r == l) {
            return (double)(num[r - 1] + num[l - 1]) / 2;
        }else {
            return (double) num[r - 1];
        }
    }


    public static void main(String[] args) {
        int[] A = new int[]{2, 3, 5, 7, 8};
        int[] B = new int[]{4};
        System.out.println(findMedianSortedArraysII(A, B));
    }
}
