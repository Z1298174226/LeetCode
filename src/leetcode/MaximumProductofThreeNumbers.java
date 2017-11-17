package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2017/11/16.
 */
public class MaximumProductofThreeNumbers {

    public static int maximumProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
       dfs(lists, list, nums, 3, 0, result);
       for(List<Integer> li : lists) {
           int product = 1;
           for(int num : li) {
               product *= num;
           }
           result = Math.max(result, product);
       }
        return result;
    }

    private static void  dfs(List<List<Integer>> lists, List<Integer> list, int[] nums, int k, int index, int result) {
        if(k == 0) {
           lists.add(new ArrayList(list));
           return;
        }
        for(int j = index; j < nums.length; j++) {
            list.add(nums[j]);
            dfs(lists, list, nums, k - 1, j + 1, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4, 45, -34, -78, 89, 4};
        System.out.println(MaximumProductofThreeNumbers.maximumProduct(nums));
    }
}
