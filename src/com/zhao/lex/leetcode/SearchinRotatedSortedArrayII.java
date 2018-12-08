package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/25.
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int length = nums.length;
        int start = 0; int end = length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return true;
            else if(nums[mid] > nums[end]) {
                if(nums[mid] > target && nums[end] < target) end = mid - 1;
                else start = mid + 1;
            }
            else if(nums[mid] < nums[end]) {
                if(nums[mid] > target || nums[end] < target) end = mid - 1;
                else start = mid + 1;
            }
            else
                end--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,6,0,0,1,2};
        System.out.println(new SearchinRotatedSortedArrayII().search(nums, 7));
    }
}
