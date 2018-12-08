package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/25.
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int length = nums.length;
        int start = 0; int end = length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[end]) {
                start = mid + 1;
            }
            else if(nums[mid] < nums[end]) {
                end = mid;
            }
            else {
                end--;
            }
        }
        return nums[start];
    }
}
