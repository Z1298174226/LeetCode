package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/3.
 */
public class BurstBalloonsII {
    public static int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for(int i = 0; i < iNums.length; i++)
            nums[n++] = iNums[i];
        nums[0] = 1; nums[n++] = 1;
        int[][] dp = new int[n][n];

        for(int k = 2; k < n; k++) {
            for(int left = 0; left < n - k; left++) {
                int right = left + k;
                for(int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], nums[left] * nums[i] * nums[right]
                    + dp[left][i] + dp[i][right]);
                }
            }
        }
       return dp[0][n-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 8};
        System.out.println(BurstBalloonsII.maxCoins(nums));
    }
}
