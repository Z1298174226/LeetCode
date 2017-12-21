package com.zhao.lex.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by qtfs on 2017/12/21.
 */
public class RussainDollII {
    public static int russionDoll(int[][] nums) {
        if(nums.length == 0 || nums[0].length == 0) return 0;
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });
        int result = 0;
        int[] dp = new int[nums.length + 1];
        for(int[] num : nums) {
            int index = Arrays.binarySearch(dp, 0, result, num[1]);
            if(index < 0)
                index = -(index + 1);
            dp[index] = num[1];
            if(index == result)
                result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 5}, {5, 6}, {5, 7}, {6, 8}};
        System.out.println(russionDoll(nums));
    }
}
