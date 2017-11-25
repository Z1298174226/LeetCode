package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/16.
 */
public class MaximumProductSubarray {

    //O(n^2)
/*
    public static int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
            result = Math.max(result, dp[i][i]);
            for(int j = i - 1; j >= 0; j--) {
                dp[j][i] = dp[j][i - 1] * nums[i];
                result = Math.max(result, dp[j][i]);
            }
        }
        return result;
    }
    */
//O(n)
    public static int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = nums[0]; int min = nums[0]; int result = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max((Math.max(max * nums[i], min * nums[i])), nums[i]);
            min = Math.min((Math.min(temp * nums[i], min * nums[i])), nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, -3, 7};
        System.out.println(MaximumProductSubarray.maxProduct(nums));
    }
}
