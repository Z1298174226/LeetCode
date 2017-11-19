package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by qtfs on 2017/11/18.
 */
public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = 0; int resultSum = 0;
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            resultSum += nums[i];
            Integer pre = map.get(resultSum - k);
            if(pre != null) {
                result += pre;
            }
            map.put(resultSum, map.getOrDefault(resultSum, 0) + 1);
        }
        return result;
    }

/*
[-19,-82,-70,-46,-29,7,15,-72,-7,100,303]
100
 */
    public static void main(String[] args) {
        int[] nums = new int[]{-19,-82,-70,-46,-29,7,15,-72,-7,100,303};
        System.out.println(SubarraySumEqualsK.subarraySum(nums, 100));
    }
}
