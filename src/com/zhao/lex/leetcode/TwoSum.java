package com.zhao.lex.leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by qtfs on 2017/11/18.
 */
public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++){
            if (map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target - numbers[i]), i};
            }
            else{
                if (!map.containsKey(numbers[i])){ // edge case: duplicate items.
                    map.put(numbers[i], i);
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{11, 15, 2, 7, 11, 15};
        for(int num : TwoSum.twoSum(nums, 9))
            System.out.println(num);
    }


}
