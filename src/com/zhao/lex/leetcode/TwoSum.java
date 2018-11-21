package com.zhao.lex.leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by qtfs on 2017/11/18.
 */
public class TwoSum {
//    public static int[] twoSum(int[] numbers, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < numbers.length; i++){
//            if (map.containsKey(target - numbers[i])) {
//                return new int[] {map.get(target - numbers[i]), i};
//            }
//            else{
//                if (!map.containsKey(numbers[i])){ // edge case: duplicate items.
//                    map.put(numbers[i], i);
//                }
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }

    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int left = 0; int right = length - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum < target) left++;
            else if(sum > target) right--;
            else
                break;
        }
        return new int[]{left + 1, right + 1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,24,50,79,88,150,345};
        for(int num : new TwoSum().twoSum(nums, 200))
            System.out.println(num);
    }


}
