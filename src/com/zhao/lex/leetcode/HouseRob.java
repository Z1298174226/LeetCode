package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2018/11/1.
 */
public class HouseRob {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int preYesHead = nums[0];
        int preNoHead = 0;
        int resultHead = Math.max(preYesHead, preNoHead);
        for(int i = 1; i < nums.length - 1; i++) {
            int temp = preNoHead;
            preNoHead = Math.max(preNoHead, preYesHead);
            preYesHead = temp + nums[i];
//            preYesHead = Math.max(temp + nums[i], preYesHead);
            resultHead = Math.max(preNoHead, preYesHead);
        }
        int preYesTail = nums[nums.length -  1];
        int preNoTail = 0;
        int resultTail = Math.max(preYesTail, preNoTail);
        for(int i = 0; i < nums.length - 2; i++) {
            int temp = preNoTail;
            preNoTail = Math.max(preNoTail, preYesTail);
            preYesTail = temp + nums[i];
//            preYesTail = Math.max(temp + nums[i], preYesTail);
            resultTail = Math.max(preNoTail, preYesTail);
        }
        return Math.max(resultHead, resultTail);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 3, 2, 7, 9, 3, 10};
        System.out.println(new HouseRob().rob(nums));
    }
}
