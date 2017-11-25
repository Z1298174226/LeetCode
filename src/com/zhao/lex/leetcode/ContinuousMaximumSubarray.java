package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/18.
 */
public class ContinuousMaximumSubarray {
    public static int[] continuousMaximumSubarray(int[] nums, int k) {
        int[] sumArray = new int[nums.length + 1];
        sumArray[0] = 0;
        int[] result = new int[2];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumArray[i + 1] = sum;
        }
        int max = 0;
        int left = 0; int right = 0;
        while(left < sumArray.length) {
            while(right < sumArray.length && sumArray[right] - sumArray[left] <= k)
                right++;
            if(max < sumArray[right - 1] - sumArray[left]) {
                max = sumArray[right - 1] - sumArray[left];
                result[0] = left; result[1] = right - 2;
            }
            left++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 6, 2, 4, 5, 6, 7, 8, 9, 0, 34,};
        for(int num : ContinuousMaximumSubarray.continuousMaximumSubarray(nums, 21))
            System.out.println(num);
    }
}
