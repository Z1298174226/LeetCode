package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/12/21.
 */
public class MaximumLengthofRepeatedSubarray {

    public static int findLengthII(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                if(A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    result = Math.max(result, dp[i + 1][j + 1]);
                }
            }
        }
        return result;
    }

    public static int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        return findMaxSubstring(A, B, A.length, B.length, dp, false);
    }

    private static int findMaxSubstring(int[] A, int[] B, int index_1, int index_2, int[][] dp, boolean marked) {
        if(dp[index_1][index_2] != 0)
            return dp[index_1][index_2];
        if(index_1 == 0 || index_2 == 0)
            return 0;
        if(A[index_1 - 1] == B[index_2 - 1]) {
            int temp = findMaxSubstring(A, B, index_1 - 1, index_2 - 1, dp, marked);
            dp[index_1][index_2] = temp + 1;
        }else {
            if(!marked) {
                marked = true;
                int temp_1 = findMaxSubstring(A, B, index_1 - 1, index_2, dp, marked);
                int temp_2 = findMaxSubstring(A, B, index_1, index_2 - 1, dp, marked);
                dp[index_1][index_2] = Math.max(temp_1, temp_2);
            }
            else dp[index_1][index_2] = findMaxSubstring(A, B, index_1 - 1, index_2 - 1, dp, marked);
        }
        return dp[index_1][index_2];
    }

    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 0, 1, 0};
        int[] B = new int[]{0, 1, 1, 1, 1};
        System.out.println(findLength(A, B));
    }
}
