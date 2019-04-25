package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/1.
 */
public class LongestSQ {
    //程序都有很不严密的地方
    /*
    public static int findLongestSQ(int[] Q) {
        int[] B = new int[Q.length];
        int len = 1;
        B[len] = Q[0];
        for(int i = 1; i < Q.length; i++) {
            int pos = help(B, 1, len, Q[i]);
            B[pos] = Q[i];
            len = Math.max(len, pos);
        }
        return len;
    }

    private static int help(int[] B, int start, int end, int value) {
        if(B[end] < value) return end + 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(B[mid] < value) start = mid + 1;
            else end = mid;
        }
        return start;
    }
    */
    public static int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        int[] B = new int[length + 1];
        int[] num = new int[length + 1];
        int len = 1;
        B[len] = nums[0];
        num[len]++;
        for(int i = 1; i < length; i++) {
            int pos = help(B, 1, len, nums[i]);
            B[pos] = nums[i];
            num[pos]++;
            len = Math.max(len, pos);
        }
        System.out.println(len);
        System.out.println(num[len]);
        return num[len];
    }

    private static int help(int[] B, int start, int end, int value) {
        if(B[end] < value) return end + 1;
        while(start < end) {
            int mid = (end - start) / 2 + start;
            if(B[mid] > value) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    public static int longestIncreasingSubsequence(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length + 1];
        dp[1] = 1;
        int result = Integer.MIN_VALUE;
        for(int i = 2; i <= length; i++) {
            for(int j  = 1; j < i; j++) {
                if(nums[i - 1] > nums[j - 1])
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                else
                    dp[i] = 1;
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }


    public static void main(String[] args) {
      //  int[] Q = new int[]{1,1,3,2,5,3,7,1,1,4,6,34,54,2,67,99};
        int[] Q = new int[]{10,9,2,5,3,7,101,18};
     //   System.out.println(LongestSQ.findLongestSQ(Q));
        System.out.println(new LongestSQ().longestSQ(Q));
    }

   public int longestSQ(int[] arr) {
        int len = arr.length;
        int[] sq = new int[len];
        int result = 1;
        sq[result] = arr[0];
        for(int i = 1; i < len; i++) {
            int temp = helps(sq, 0, result, arr[i]);
            sq[temp] = arr[i];
            result = Math.max(result, temp);
        }
        return result;
   }

   private int helps(int[] sq, int start, int end, int num) {
        if(sq[end] < num) {
            end++;
            return end;
        }
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(sq[mid] <= num) start = mid + 1;
            else end = mid;
        }
        return start;
   }


}
