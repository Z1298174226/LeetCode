package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/10/31.
 */
public class PredictWinner {

    public static boolean PredictTheWinner(int[] nums) {
        int index = 0;
        int num_player1 = 0;
        int num_player2 = 0;
        while(true) {
            num_player1 += Math.max(nums[index++], nums[nums.length - 1]);
            if(index == nums.length )
                break;
            num_player2 += Math.max(nums[index++], nums[nums.length - 1]);
            if(index == nums.length )
                break;
        }
        return num_player1 >= num_player2;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,567,1,1};
        System.out.println(PredictWinner.PredictTheWinner(nums));
    }
}
