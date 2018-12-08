package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/27.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int length = 0;
        int start = 0; int end = length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                end = mid - 1;
            }
            else if(nums[mid] < target) {
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(new SearchInsertPosition().searchInsert(nums, 5));
    }
}
