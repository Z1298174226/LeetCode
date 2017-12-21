package com.zhao.lex.leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by qtfs on 2017/12/11.
 */
public class FindEqualLength01 {
    public static int longestLength(String s) {
        int result = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();
        int[] nums = new int[chars.length];
        for(int i = 0; i < chars.length; i++) {
            nums[i] = chars[i] - 48;
            if(nums[i] == 0)
                nums[i] = -1;
        }
        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        while(left < nums.length) {
            right = Math.min(left, right);
            while(right < nums.length) {
                int sum = 0;
                for(int i = left; i <= right; i++) {
                    sum += nums[i];
                }
                Integer pre = map.get(sum);
                if(pre != null) {
                    result = Math.max(result, right - left + 1);
                    right++;
                }
                else
                    right++;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "0000001000000000000000000000000000000111111111111111111111101011111111111001110000000000000000000000000000001111111111111111111111010111111111110011";
        System.out.println(longestLength(s));
    }
}
