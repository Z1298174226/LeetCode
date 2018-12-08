package com.zhao.lex.leetcode;

import java.util.Arrays;

/**
 * Created by qtfs on 2017/11/24.
 */
public class SplitArrayLargestSum {
    /*
    public static int splitArray(int[] nums, int m) {
        int result = Integer.MAX_VALUE;
        int[] sumArray = new int[nums.length + 1];
        int sum = 0;
        for(int i = 1; i <= nums.length; i++) {
            sum += nums[i - 1];
            sumArray[i] = sum;
        }

        return result;
    }

    private static int dfs(int[] sumArray, int m, int start_index, int result) {
        if(m == 0) return result;
        for(int i = start_index; i < sumArray.length; i++) {

        }
    }
    */
    /*
    public static int splitArray(int[] nums, int m) {
        int L = nums.length;
        int[] S = new int[L+1];
        S[0]=0;
        for(int i=0; i<L; i++)
            S[i+1] = S[i]+nums[i];

        int[] dp = new int[L];
        for(int i=0; i<L; i++)
            dp[i] = S[L]-S[i];

        for(int s=1; s<m; s++)
        {
            for(int i=0; i<L-s; i++)
            {
                dp[i]=Integer.MAX_VALUE;
                for(int j=i+1; j<=L-s; j++)
                {
                    int t = Math.max(dp[j], S[j]-S[i]);
                    if(t<=dp[i])
                        dp[i]=t;
                    else
                        break;
                }
            }
        }

        return dp[0];
    }
*/
/*
    public static int splitArray(int[] nums, int m) {
        int max = 0; long sum = 0;
            for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) return (int)sum;
        long l = max; long r = sum;
        while (l <= r) {
            long mid = (l + r)/ 2;
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)l;
    }
    public static boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
    */

    public static int splitArray(int[] nums, int m) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if(m == 1) return sum;
        int right = sum; int left = max;
        while(left < right) {
            int mid = (right - left) / 2 + left;
            if(help(mid, nums, m))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    private static boolean help(int target, int[] nums, int m) {
        int sum = 0;
        int count = 1;
        for(int num : nums) {
            sum += num;
            if(sum > target) {
                sum = num;
                count++;
                if(count > m)
                    return false;
            }
        }
        return true;
    }
    /*
    DP, O(N*N*m)
     */
    public static int splitArrayII(int[] nums, int m) {
        if(nums == null || nums.length == 0 || m == 0) return 0;
        int length = nums.length;
        int[] sum = new int[length + 1];
        for(int i = 0; i < length; i++)
            sum[i + 1] = sum[i] + nums[i];
        if(m == 1) return sum[length];
        int[][] dp = new int[length][m + 1];
        for(int i = 0; i < length; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        for(int i = 0; i < length; i++)
            dp[i][1] = sum[i + 1];
        for(int k = 2; k <= m; k++) {
            for(int i = 0; i < length; i++) {
                for(int j = 0; j < i; j++) {
                    int temp = Math.max(dp[j][k - 1], sum[i + 1] - sum[j + 1]);
                    dp[i][k] = Math.min(dp[i][k], temp);
                }

            }
        }
        return dp[length - 1][m];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{43, 24, 56, 1, 34, 7, 9, 16, 25, 35, 67, 102};
        System.out.println(SplitArrayLargestSum.splitArrayII(nums, 4));
    }

}
