package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/18.
 */
public class ContinuousMinimumSubarray {
    public static int[] continuousMinimumSubarray(int[] nums, int k) {
        int[] sumArray = new int[nums.length + 1];
        sumArray[0] = 0;
        int[] result = new int[2];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumArray[i + 1] = sum;
        }
        int right = 0; int left = 0;
        int min = Integer.MAX_VALUE;
        while(left < sumArray.length) {
            while(right < sumArray.length && right - left < k)
                right++;
            if(right < sumArray.length && min > sumArray[right] - sumArray[left]) {
                min = sumArray[right] - sumArray[left];
                result[0] = left;
                result[1] = right - 1;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 6, 2, 4, 5, 6, 7, 8, 9, 0, 7, 0, 0, 0, 0, 0};
        for(int num :ContinuousMinimumSubarray.continuousMinimumSubarray(nums, 9))
            System.out.println(num);
    }
}
