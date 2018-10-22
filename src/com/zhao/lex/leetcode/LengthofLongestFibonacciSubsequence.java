package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/9/6.
 */
public class LengthofLongestFibonacciSubsequence {
//    public int lenLongestFibSubseq(int[] A) {
//        int length = A.length;
//        int max = 2;
//        if(length <= 2) return 0;
//        int[][] dp = new int[length + 1][2];
//        int index = 2;
//        dp[index][0] = A[0];
//        dp[index][1] = A[1];
//        for(int i = 2; i < length; i++) {
//            int pos = help(dp, 2, max, A[i]);
//            max = Math.max(max, pos);
//        }
//        return max == 2 ? 0 : max;
//    }
//
//    private int help(int[][] dp, int start, int end, int value) {
//        if(value == dp[end][0] + dp[end][1]) {
//            dp[end + 1][0] = dp[end][1];
//            dp[end + 1][1] = value;
//            return end + 1;
//        }
//        while(start < end) {
//            if(dp[end][0] + dp[end][1] < value) {
//                start = mid + 1;
//                dp[end][1] = value;
//            }
//            else if(dp[mid][0] + dp[mid][1] > value) {
//                end = mid;
//                dp[end][0] = value;
//            }
//            else {
//                dp[mid + 1][0] = dp[mid][1];
//                dp[mid + 1][1] = value;
//                return mid + 1;
//            }
//        }
//        return end;
//    }

    public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        int max = 0;
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                int sum = A[l] + A[r];
                if (sum > A[i]) {
                    r--;
                } else if (sum < A[i]) {
                    l++;
                } else {
                    dp[r][i] = dp[l][r] + 1;
                    max = Math.max(max, dp[r][i]);
                    r--;
                    l++;
                }
            }
        }
        return max == 0 ? 0 : max + 2;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,4,3,5,6,7,8};
        System.out.println(new LengthofLongestFibonacciSubsequence().lenLongestFibSubseq(A));
    }
}
